package com.example.cyberbeholder.ui_classes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cyberbeholder.common.APIConstants
import com.example.cyberbeholder.models.HeroModel
import com.example.cyberbeholder.retrofit.HeroRepositoryContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainHeroViewModel(private val repository: HeroRepositoryContract): ViewModel() {
    var heroes: MutableLiveData<List<HeroModel>> = MutableLiveData()
    private var compositeDisposable = CompositeDisposable()

    //left from first v
    fun getHeroes(){

        compositeDisposable.add(repository.getOWHeroesFromDB()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{response->
                heroes.value = response
            }
        )
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}