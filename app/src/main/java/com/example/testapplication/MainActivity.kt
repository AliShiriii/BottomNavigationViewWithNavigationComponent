package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.testapplication.databinding.ActivityMainBinding
import com.example.testapplication.databinding.FragmentRequestBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navigationButton : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        navigationButton = binding.navButton

        NavigationUI.setupActionBarWithNavController(this, navController )
        NavigationUI.setupWithNavController(navigationButton, navController)

    }

    override fun onSupportNavigateUp(): Boolean {

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        return navController.navigateUp() or
                super.onSupportNavigateUp()

    }
}