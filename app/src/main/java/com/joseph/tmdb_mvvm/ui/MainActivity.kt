package com.joseph.tmdb_mvvm.ui

import android.os.Bundle
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.base.BaseActivity
import com.joseph.tmdb_mvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}