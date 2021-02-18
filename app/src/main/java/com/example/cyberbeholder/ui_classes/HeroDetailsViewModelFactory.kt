package com.example.cyberbeholder.ui_classes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cyberbeholder.retrofit.HeroRepositoryContract

class HeroDetailsViewModelFactory(private val repository: HeroRepositoryContract, private val heroId: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HeroDetailsViewModel(repository, heroId) as T
    }
}