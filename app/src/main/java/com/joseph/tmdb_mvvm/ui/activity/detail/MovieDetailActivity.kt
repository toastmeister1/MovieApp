package com.joseph.tmdb_mvvm.ui.activity.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.chip.Chip
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.base.BaseActivity
import com.joseph.tmdb_mvvm.databinding.ActivityMovieDetailBinding
import com.joseph.tmdb_mvvm.ui.activity.detail.adapter.CreditsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailActivity :
    BaseActivity<ActivityMovieDetailBinding>(R.layout.activity_movie_detail) {

    private val movieDetailViewModel by viewModels<MovieDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@MovieDetailActivity
            viewModel = movieDetailViewModel
            creditAdapter = CreditsAdapter()
        }
    }
}