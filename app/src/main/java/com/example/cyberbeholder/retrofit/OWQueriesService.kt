package com.example.cyberbeholder.retrofit

import com.example.cyberbeholder.models.HeroModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OWQueriesService {

    //before it was Call<MutableList<HeroModel>>
    @GET("heroes")
    fun getHeroList(
            @Query("token") token: String
    ): Single<List<HeroModel>>

    //later on use @Query and @QueryMap to filter some stuff

    //https://developers.pandascore.co/doc/index_ow.htm#operation/get_ow_heroes
}