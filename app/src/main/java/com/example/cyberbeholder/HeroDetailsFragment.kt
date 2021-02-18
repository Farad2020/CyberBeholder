package com.example.cyberbeholder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cyberbeholder.databinding.FragmentHeroDetailsBinding
import com.example.cyberbeholder.databinding.FragmentMatchesBinding
import com.example.cyberbeholder.models.HeroModel
import com.example.cyberbeholder.retrofit.HeroRepositoryContractImpl
import com.example.cyberbeholder.retrofit.RetrofitClient
import com.example.cyberbeholder.ui_classes.*
import com.squareup.picasso.Picasso
import kotlin.properties.Delegates

class HeroDetailsFragment : Fragment() {

    private val HERO_ID_KEY = "hero_id"

    private var _binding: FragmentHeroDetailsBinding? = null
    private val binding get() = _binding!!

    //Retrofit
    private val retrofit = RetrofitClient.retrofitServices

    //not sure whether the following the line is ok or not
    private val repository = HeroRepositoryContractImpl(retrofit)

    //model-view factory
    private lateinit var modelViewFactory: HeroDetailsViewModelFactory

    //ViewModel
    private lateinit var viewModel: HeroDetailsViewModel

    //Hero id
    //cant lateinit primitive types(
    private var heroId by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            heroId = it.getInt(HERO_ID_KEY)
            modelViewFactory = HeroDetailsViewModelFactory(repository, heroId)
            viewModel = ViewModelProvider(this, modelViewFactory).get(HeroDetailsViewModel::class.java)

            // here is the question. Should I provide one time id in factory, or should I pass the var as an argument
            viewModel.getHero()

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentHeroDetailsBinding.inflate(inflater, container, false)

        val heroObserver = Observer<HeroModel> { hero ->
            binding.heroRealName.setText(hero.real_name)
            binding.heroName.setText(hero.name)
            binding.heroRoleName.setText(hero.role)
            binding.heroDifficulty.setText(hero.difficulty.toString())
            Picasso.get().load(hero.portrait_url).into(binding.heroPortrait)
            Picasso.get().load(hero.image_url).into(binding.heroImage)

        }

        viewModel.hero.observe(viewLifecycleOwner, heroObserver)


        return binding.root
    }
}