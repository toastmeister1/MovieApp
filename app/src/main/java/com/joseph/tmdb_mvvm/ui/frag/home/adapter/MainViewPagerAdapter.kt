package com.joseph.tmdb_mvvm.ui.frag.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.databinding.ItemMainViewpagerBinding
import com.joseph.tmdb_mvvm.ui.frag.home.model.ViewPagerInfo

class MainViewPagerAdapter : RecyclerView.Adapter<MainViewPagerAdapter.MainViewPagerViewHolder>() {

    private var itemList = ArrayList<ViewPagerInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewPagerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemMainViewpagerBinding>(layoutInflater, R.layout.item_main_viewpager, parent, false)

        return MainViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MainViewPagerViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    fun submitList(list: ArrayList<ViewPagerInfo>) {
        this.itemList = list
    }

    inner class MainViewPagerViewHolder(private var binding: ItemMainViewpagerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(info: ViewPagerInfo) {
            binding.apply {
                viewPagerItem = info
            }
        }

    }
}