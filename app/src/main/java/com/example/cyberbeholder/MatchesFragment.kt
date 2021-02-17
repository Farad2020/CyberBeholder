package com.example.cyberbeholder

import android.app.AlertDialog
import android.graphics.Movie
import android.os.Bundle
import android.service.autofill.FieldClassification
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cyberbeholder.common.APIConstants
import com.example.cyberbeholder.common.Common
import com.example.cyberbeholder.databinding.FragmentMatchesBinding
import com.example.cyberbeholder.models.HeroModel
import com.example.cyberbeholder.retrofit.APIRepository
import com.example.cyberbeholder.retrofit.RetrofitClient
import com.example.cyberbeholder.ui_classes.MainHeroViewModel
import com.example.cyberbeholder.ui_classes.MainHeroViewModelFactory
import com.example.cyberbeholder.ui_classes.MatchesRecyclerViewAdapter
import com.example.cyberbeholder.ui_classes.TestDataClass
import dmax.dialog.SpotsDialog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.internal.util.NotificationLite.accept
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchesFragment : Fragment() {
    //Recycler View
    private lateinit var recyclerView: RecyclerView

    //ViewModel
    private lateinit var viewModel: MainHeroViewModel

    // Use of bindings to simplify connection of xml elements
    private var _binding: FragmentMatchesBinding? = null
    private val binding get() = _binding!!

    // Alerting
    lateinit var dialog: AlertDialog

    // RXJava
    private var compositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentMatchesBinding.inflate(inflater, container, false)

        recyclerView = binding.matchesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        dialog = SpotsDialog.Builder().setCancelable(true).setContext(requireContext()).build()


        getAllHeroes()
        return binding.root
    }

    private fun getAllHeroes() {
        val repository = APIRepository()

        compositeDisposable.add(repository.getOWHeroes(APIConstants.TEST_TOKEN)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))

//        compositeDisposable.add(repository.getOWHeroes(APIConstants.TEST_TOKEN)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(Consumer<List<HeroModel>>(){
//                    override fun accept(){
//
//                    }
//                }))

        //instead of observable I used Call before

//        val repository = APIRepository()
//        val retrofit = RetrofitClient.retrofitServices
//        val modelViewFactory = MainHeroViewModelFactory(repository)
//
//        viewModel = ViewModelProvider(this, modelViewFactory).get(MainHeroViewModel::class.java)
//        viewModel.getHeroes(APIConstants.TEST_TOKEN)
//        viewModel.myResponse.enqueue(object : Callback<List<HeroModel>> {
//            override fun onFailure(call: Call<List<HeroModel>>, t: Throwable) {
//
//            }
//
//            override fun onResponse(
//                    call: Call<List<HeroModel>>,
//                    response: Response<List<HeroModel>>
//            ) {
//                val adapter =
//                        MatchesRecyclerViewAdapter(response.body() as MutableList<HeroModel>)
//                adapter.notifyDataSetChanged()
//                recyclerView.adapter = adapter
//
//                dialog.dismiss()
//            }
//        })
    }

    private fun handleResponse(cryptoList: List<HeroModel>) {
        val myHeroList = ArrayList(cryptoList)
        val myAdapter = MatchesRecyclerViewAdapter(myHeroList)
        recyclerView.adapter = myAdapter
    }

    override fun onStop() {
        //clearing all disposables
        compositeDisposable.clear()
        super.onStop()
    }

    companion object {
    }
}