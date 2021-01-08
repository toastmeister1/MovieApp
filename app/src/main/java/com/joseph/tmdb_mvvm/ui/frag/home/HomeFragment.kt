package com.joseph.tmdb_mvvm.ui.frag.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.base.BaseFragment
import com.joseph.tmdb_mvvm.databinding.FragmentHomeBinding
import com.joseph.tmdb_mvvm.ui.frag.home.adapter.MainViewPagerAdapter
import com.joseph.tmdb_mvvm.ui.frag.home.adapter.MovieListAdapter
import com.joseph.tmdb_mvvm.ui.frag.home.model.DummyViewPagerInfo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var viewPagerAdater: MainViewPagerAdapter
    private var movieListAdapter = MovieListAdapter()

    private var fetchJob: Job? = null

    private fun fetch() {
        fetchJob?.cancel()
        fetchJob = lifecycleScope.launch {
            viewModel.fetchPopularMovieList().collectLatest {
                movieListAdapter.submitData(it)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewPager()
        initAdapter()
        fetch()
    }

    fun initViewPager() {
        viewPagerAdater = MainViewPagerAdapter()
        viewPagerAdater.submitList(DummyViewPagerInfo.DUMMY_PAGER_INFO_LIST)

        binding!!.mainViewpager.apply {
            adapter = viewPagerAdater
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }

    fun initAdapter() {
        var popularLayoutManager = LinearLayoutManager(fragContext, LinearLayoutManager.HORIZONTAL, false)
        movieListAdapter = MovieListAdapter()

        binding?.popularRecyclerview?.apply {
            adapter = movieListAdapter
            layoutManager = popularLayoutManager
            setHasFixedSize(true)
        }
    }

}