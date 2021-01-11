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

    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var viewPagerAdater: MainViewPagerAdapter

    private var job1: Job? = null
    private var job2: Job? = null
    private var job3: Job? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = homeViewModel
            popularAdapter = MovieListAdapter()
            upComingAdapter = MovieListAdapter()
            topRatedAdapter = MovieListAdapter()
        }
        initViewPager()

        fetchPopularList()
        fetchUpComingList()
        fetchTopRatedList()
    }

    private fun fetchPopularList() {
        job1?.cancel()
        job1 = lifecycleScope.launch {
            homeViewModel.fetchPopularMovieList().collectLatest {
                binding?.popularAdapter?.submitData(it)
            }
        }
    }

    private fun fetchUpComingList() {
        job2?.cancel()
        job2 = lifecycleScope.launch {
            homeViewModel.fetchUpComingMovieList().collectLatest {
                binding?.upComingAdapter?.submitData(it)
            }
        }
    }

    private fun fetchTopRatedList() {
        job3?.cancel()
        job3 = lifecycleScope.launch {
            homeViewModel.fetchTopRatedMovieList().collectLatest {
                binding?.topRatedAdapter?.submitData(it)
            }
        }

    }

    private fun initViewPager() {
        viewPagerAdater = MainViewPagerAdapter()
        viewPagerAdater.submitList(DummyViewPagerInfo.DUMMY_PAGER_INFO_LIST)

        binding!!.mainViewpager.apply {
            adapter = viewPagerAdater
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }

}