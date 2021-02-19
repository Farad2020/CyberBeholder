package com.example.cyberbeholder.retrofit

import androidx.lifecycle.LiveData
import com.example.cyberbeholder.data.dao.OWHeroesDao
import com.example.cyberbeholder.models.HeroModel
import io.reactivex.Single

class HeroRepositoryContractImpl(private val retrofitService: OWQueriesService,
                                private val heroesDao: OWHeroesDao): HeroRepositoryContract {

    //before it was  Call<MutableList<HeroModel>>
    override fun getOWHeroes(token: String): Single<List<HeroModel>> {
        return retrofitService.getHeroList(token).doOnEvent { data, throwable ->
            saveOWHeroes(data)
        }
    }

    override fun getOWHeroById(token: String, id: Int): Single<HeroModel> {
        return retrofitService.getHeroById(id, token)
    }

    override fun getOWHeroesFromDB(): Single<List<HeroModel>> {
        return heroesDao.getAllHeroes()
    }

    override fun getOWHeroByIdFromDB(id: Int): Single<HeroModel> {
        return heroesDao.getHeroByIds(id)
    }


    override fun saveOWHeroes(heroes: List<HeroModel>) {
        heroesDao.insertAll(heroes)
    }
}