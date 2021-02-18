package com.example.cyberbeholder.ui_classes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cyberbeholder.common.APIConstants
import com.example.cyberbeholder.models.HeroModel
import com.example.cyberbeholder.retrofit.HeroRepositoryContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HeroDetailsViewModel(private val repository: HeroRepositoryContract, private val heroId: Int): ViewModel()  {
    var hero: MutableLiveData<HeroModel> = MutableLiveData()
    private var compositeDisposable = CompositeDisposable()

    fun getHero(){
        compositeDisposable.add(repository.getOWHeroById(APIConstants.TEST_TOKEN, heroId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{response->
                hero.value = response
            }
        )
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}