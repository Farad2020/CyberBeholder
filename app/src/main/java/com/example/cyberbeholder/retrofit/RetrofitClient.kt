package com.example.cyberbeholder.retrofit

import com.example.cyberbeholder.common.APIConstants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(APIConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //should google what the following means later
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    val retrofitServices: RetrofitServices by lazy {
        retrofit.create(RetrofitServices::class.java)
    }

//    var retrofit: Retrofit? = null
//
//    fun getClient(myBaseUrl: String): Retrofit{
//        if (retrofit == null) {
//            retrofit = Retrofit.Builder()
//                .baseUrl(myBaseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }
//        return retrofit!!

        //Wasnt sure whether following code would work as intended
//        return retrofit ?: synchronized(this) {
//            retrofit = Retrofit.Builder()
//                .baseUrl(myBaseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//            return retrofit!!
//        }
}