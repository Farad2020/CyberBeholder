package com.example.cyberbeholder.ui_classes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cyberbeholder.common.APIConstants
import com.example.cyberbeholder.models.HeroModel
import com.example.cyberbeholder.retrofit.APIRepository
import com.example.cyberbeholder.retrofit.RetrofitClient
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MainHeroViewModel(private val repository: APIRepository): ViewModel() {
    lateinit var myResponse: Observable<List<HeroModel>>

    //left from first v
    fun getHeroes(token: String){
        viewModelScope.launch {
            val response = repository.getOWHeroes(token)
            myResponse = response
        }
    }
}