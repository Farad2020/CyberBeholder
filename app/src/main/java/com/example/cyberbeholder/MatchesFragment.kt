package com.example.cyberbeholder

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cyberbeholder.data.Injection
import com.example.cyberbeholder.databinding.FragmentMatchesBinding
import com.example.cyberbeholder.models.HeroModel
import com.example.cyberbeholder.retrofit.HeroRepositoryContract
import com.example.cyberbeholder.retrofit.HeroRepositoryContractImpl
import com.example.cyberbeholder.retrofit.RetrofitClient
import com.example.cyberbeholder.ui_classes.MainHeroViewModel
import com.example.cyberbeholder.ui_classes.MainHeroViewModelFactory
import com.example.cyberbeholder.ui_classes.MatchesRecyclerViewAdapter
import com.example.cyberbeholder.ui_classes.OnHeroItemInteraction
import org.koin.android.ext.android.get
import org.koin.java.KoinJavaComponent.get

//Currently you load data from database only.
// TODO: Figure out the best way to call API and Database data at once

class MatchesFragment : Fragment(), OnHeroItemInteraction {
    //Recycler View
    private lateinit var recyclerView: RecyclerView

    // Use of bindings to simplify connection of xml elements
    private var _binding: FragmentMatchesBinding? = null
    private val binding get() = _binding!!

    //ViewModel
    private var viewModel =  get<MainHeroViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentMatchesBinding.inflate(inflater, container, false)

        recyclerView = binding.matchesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.getHeroes()

        val heroesObserver = Observer<List<HeroModel>> { heroes ->
            val myHeroList = ArrayList(heroes)
            val myAdapter = MatchesRecyclerViewAdapter(myHeroList, this)
            recyclerView.adapter = myAdapter
        }

        viewModel.heroes.observe(viewLifecycleOwner, heroesObserver)

        return binding.root
    }

    override fun onHeroInteraction(heroId: Int) {
        val action = MatchesFragmentDirections.actionMatchesFragmentToHeroDetailsFragment(heroId)
        findNavController().navigate(action)
    }
}