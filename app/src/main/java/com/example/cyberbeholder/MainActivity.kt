package com.example.cyberbeholder

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    private lateinit var _fragment: MatchesFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // creating fragment and adding it to fragments in the activity_main
//        _fragment = MatchesFragment()
//        val fm = supportFragmentManager
//        val tr = fm.beginTransaction()
//        tr.add(R.id.my_fragment_holder, _fragment)
//        tr.commitAllowingStateLoss()

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)

        //how to easy get viewmodel for fragment - https://developer.android.com/reference/androidx/lifecycle/ViewModel


        //YO DONT FORGET, DESTROY FRAGMENT OR ACTIVITY
    }

    override fun onDestroy() {
        super.onDestroy()
//        Log.d("DEST", "DESSTROYED")
//        supportFragmentManager.beginTransaction().remove(_fragment)
        //clearBackStack()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}