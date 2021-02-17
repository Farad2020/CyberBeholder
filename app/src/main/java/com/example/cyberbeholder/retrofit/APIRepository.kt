package com.example.cyberbeholder.retrofit

import com.example.cyberbeholder.common.APIConstants
import com.example.cyberbeholder.models.HeroModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response

class APIRepository {

    //before it was  Call<MutableList<HeroModel>>
    fun getOWHeroes(token: String): Observable<List<HeroModel>> {
        return RetrofitClient.retrofitServices.getHeroList(token)
    }
}