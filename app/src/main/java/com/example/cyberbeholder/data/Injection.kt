package com.example.cyberbeholder.data

import android.content.Context
import com.example.cyberbeholder.data.dao.OWHeroesDao
import com.example.cyberbeholder.data.database.BeholderDatabase
import com.example.cyberbeholder.ui_classes.MainHeroViewModelFactory

object  Injection {
    fun provideUserDataSource(context: Context): OWHeroesDao {
        return BeholderDatabase.getDatabase(context)!!.heroesDao()
    }
}