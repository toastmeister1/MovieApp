package com.joseph.tmdb_mvvm.ui.activity.main

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.base.BaseActivity
import com.joseph.tmdb_mvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBottomNav()
    }

    private fun initBottomNav() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.findNavController()
        binding.mainBottomNavigation.apply {
            setupWithNavController(navController)
            setOnNavigationItemSelectedListener { item ->
                navController.navigate(item.itemId, null)
                if(item.itemId == R.id.homeFragment) {
                    window?.statusBarColor = Color.argb(0,100,100,100)
                } else {
                    window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.blackBlendedWhite)
                }
                true
            }
        }
    }
}
