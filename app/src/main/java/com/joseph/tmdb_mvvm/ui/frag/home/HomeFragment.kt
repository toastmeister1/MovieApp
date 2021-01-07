package com.joseph.tmdb_mvvm.ui.frag.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.base.BaseFragment
import com.joseph.tmdb_mvvm.databinding.FragmentHomeBinding
import com.joseph.tmdb_mvvm.ui.frag.home.adapter.MainViewPagerAdapter


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private lateinit var viewPagerAdater: MainViewPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewPager()
    }

    fun initViewPager() {
        viewPagerAdater = MainViewPagerAdapter()
        viewPagerAdater.submitList(DummyViewPagerInfo.DUMMY_PAGER_INFO_LIST)

        binding!!.mainViewpager.apply {
            adapter = viewPagerAdater
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }

}