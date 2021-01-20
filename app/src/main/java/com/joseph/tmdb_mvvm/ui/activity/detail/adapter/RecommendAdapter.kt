package com.joseph.tmdb_mvvm.ui.activity.detail.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.databinding.ItemRecommandBinding
import com.joseph.tmdb_mvvm.model.Movie
import com.joseph.tmdb_mvvm.ui.activity.detail.MovieDetailActivity

class RecommendAdapter : RecyclerView.Adapter<RecommendAdapter.RecommandViewHolder>() {

    private var movieList = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommandViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemRecommandBinding>(layoutInflater, R.layout.item_recommand, parent, false)

        return RecommandViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommandViewHolder, position: Int) {
        holder.binding.apply {
            movie = movieList[position]
            root.setOnClickListener{
                val intent = Intent(it.context, MovieDetailActivity::class.java)
                intent.putExtra("movieId", movieList[position].id)
                it.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun submitList(list: List<Movie>) {
        movieList.addAll(list)
        notifyDataSetChanged()
    }

    class RecommandViewHolder(val binding: ItemRecommandBinding) : RecyclerView.ViewHolder(binding.root)
}