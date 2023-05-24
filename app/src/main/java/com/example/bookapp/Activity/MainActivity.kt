package com.example.bookapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bookapp.Fragment.Main.Favorite
import com.example.bookapp.Fragment.Main.Home
import com.example.bookapp.Fragment.Main.Settings
import com.example.bookapp.R
import com.example.bookapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())


        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment -> replaceFragment(Home())
                R.id.favoriteFragment -> replaceFragment(Favorite())
                R.id.settingsFragment -> replaceFragment(Settings())
                else -> {

                }
            }
            true
        }
    }



    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.Fragment_layout,fragment)
        fragmentTransaction.commit()
    }
}