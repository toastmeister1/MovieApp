package com.joseph.tmdb_mvvm.ui.frag.home

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.view.WindowManager
import android.widget.AbsListView
import android.widget.ScrollView
import androidx.annotation.RequiresApi
import androidx.core.graphics.alpha
import androidx.core.view.WindowCompat
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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
import okhttp3.internal.toHexString

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var viewPagerAdater: MainViewPagerAdapter

    private var popularListJob: Job? = null
    private var upComingListJob: Job? = null
    private var topRatedListJob: Job? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
    }

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
        popularListJob?.cancel()
        popularListJob = lifecycleScope.launch {
            homeViewModel.fetchPopularMovieList().collectLatest {
                binding?.popularAdapter?.submitData(it)
            }
        }
    }

    private fun fetchUpComingList() {
        upComingListJob?.cancel()
        upComingListJob = lifecycleScope.launch {
            homeViewModel.fetchUpComingMovieList().collectLatest {
                binding?.upComingAdapter?.submitData(it)
            }
        }
    }

    private fun fetchTopRatedList() {
        topRatedListJob?.cancel()
        topRatedListJob = lifecycleScope.launch {
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
