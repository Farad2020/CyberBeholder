package com.example.cyberbeholder.ui_classes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cyberbeholder.MatchesFragment
import com.example.cyberbeholder.common.APIConstants
import com.example.cyberbeholder.models.HeroModel
import com.example.cyberbeholder.retrofit.APIRepository
import com.example.cyberbeholder.retrofit.HeroRepositoryContract
import com.example.cyberbeholder.retrofit.RetrofitClient
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MainHeroViewModel(private val repository: HeroRepositoryContract): ViewModel() {
    var heroes: MutableLiveData<List<HeroModel>> = MutableLiveData()
    private var compositeDisposable = CompositeDisposable()

    //left from first v
    fun getHeroes(){
//        viewModelScope.launch {
//            val response = repository.getOWHeroes(token)
//            myResponse = response
//        }
//
//        val repository = APIRepository(RetrofitClient.retrofitServices)

        compositeDisposable.add(repository.getOWHeroes(APIConstants.TEST_TOKEN)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{response->
                heroes.value = response
            }
        )
    }

    fun disposeDisposables(){
        compositeDisposable.dispose()
    }


}