package com.example.cyberbeholder.ui_classes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cyberbeholder.retrofit.APIRepository

class MainHeroViewModelFactory(private val repository: APIRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainHeroViewModel(repository) as T
    }
}