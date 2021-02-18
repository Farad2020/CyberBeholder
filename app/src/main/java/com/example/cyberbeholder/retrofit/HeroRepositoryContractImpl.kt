package com.example.cyberbeholder.retrofit

import com.example.cyberbeholder.models.HeroModel
import io.reactivex.Single

class HeroRepositoryContractImpl(private val retrofitService: OWQueriesService): HeroRepositoryContract {

    //before it was  Call<MutableList<HeroModel>>
    override fun getOWHeroes(token: String): Single<List<HeroModel>> {
        return retrofitService.getHeroList(token)
    }

    override fun getOWHeroById(token: String, id: Int): Single<HeroModel> {
        return retrofitService.getHeroById(id, token)
    }
}