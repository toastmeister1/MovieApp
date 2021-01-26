package com.joseph.tmdb_mvvm.ui.activity.detail

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.base.BaseActivity
import com.joseph.tmdb_mvvm.databinding.ActivityMovieDetailBinding
import com.joseph.tmdb_mvvm.ui.activity.detail.adapter.CreditsAdapter
import com.joseph.tmdb_mvvm.ui.activity.detail.adapter.RecommendAdapter
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
            recommendAdapter = RecommendAdapter()
            mdRecommandRecyclerview.layoutManager = GridLayoutManager(this.root.context, 2, GridLayoutManager.HORIZONTAL, false)
        }
    }
}
