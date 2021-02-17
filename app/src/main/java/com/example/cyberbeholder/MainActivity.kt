package com.example.cyberbeholder

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    private lateinit var _fragment: MatchesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // creating fragment and adding it to fragments in the activity_main
        _fragment = MatchesFragment()
        val fm = supportFragmentManager
        val tr = fm.beginTransaction()
        tr.add(R.id.my_fragment_holder, _fragment)
        tr.commitAllowingStateLoss()
        //how to easy get viewmodel for fragment - https://developer.android.com/reference/androidx/lifecycle/ViewModel


        //YO DONT FORGET, DESTROY FRAGMENT OR ACTIVITY
    }

    override fun onDestroy() {
        super.onDestroy()
//        Log.d("DEST", "DESSTROYED")
//        supportFragmentManager.beginTransaction().remove(_fragment)
        //clearBackStack()
    }

    private fun clearBackStack() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first =
                manager.getBackStackEntryAt(0)
            manager.popBackStack(
                first.id,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }
    }
}