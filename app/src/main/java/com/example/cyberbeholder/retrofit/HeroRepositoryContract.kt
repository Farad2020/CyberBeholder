package com.example.cyberbeholder.retrofit

import com.example.cyberbeholder.models.HeroModel
import io.reactivex.Single

interface HeroRepositoryContract {

    fun getOWHeroes(token: String): Single<List<HeroModel>>
}
