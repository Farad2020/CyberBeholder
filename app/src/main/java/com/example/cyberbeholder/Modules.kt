package com.example.cyberbeholder

import com.example.cyberbeholder.data.database.BeholderDatabase
import com.example.cyberbeholder.retrofit.HeroRepositoryContract
import com.example.cyberbeholder.retrofit.HeroRepositoryContractImpl
import com.example.cyberbeholder.retrofit.RetrofitClient
import com.example.cyberbeholder.ui_classes.HeroDetailsViewModel
import com.example.cyberbeholder.ui_classes.MainHeroViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module{
    single {RetrofitClient.retrofitServices}

    single { BeholderDatabase.getDatabase(androidContext())!!.heroesDao()}

    single { HeroRepositoryContractImpl(get(), get()) as HeroRepositoryContract }

    viewModel { MainHeroViewModel(get()) }

    //previously I used to pass Hero Id, but now Im passing only repo

    viewModel { HeroDetailsViewModel(get()) }
}