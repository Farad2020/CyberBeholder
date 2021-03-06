package com.example.cyberbeholder.retrofit

import androidx.lifecycle.LiveData
import com.example.cyberbeholder.models.HeroModel
import io.reactivex.Single

interface HeroRepositoryContract {

    fun getOWHeroes(token: String): Single<List<HeroModel>>

    fun getOWHeroById(token: String, id: Int): Single<HeroModel>

    fun getOWHeroesFromDB(): Single<List<HeroModel>>

    fun getOWHeroByIdFromDB(id: Int): Single<HeroModel>

    fun saveOWHeroes(heroes: List<HeroModel>)
}
