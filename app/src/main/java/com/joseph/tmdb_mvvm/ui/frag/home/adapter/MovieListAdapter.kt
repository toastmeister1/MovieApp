package com.joseph.tmdb_mvvm.ui.frag.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.databinding.ItemMovieBinding
import com.joseph.tmdb_mvvm.model.MovieListResponse

class MovieListAdapter :
    PagingDataAdapter<MovieListResponse.Movie, MovieListAdapter.MovieListViewHolder>(
        MOVIE_COMPARATOR
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemMovieBinding>(
            layoutInflater,
            R.layout.item_movie,
            parent,
            false
        )
        return MovieListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)
    }

    inner class MovieListViewHolder(private var binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: MovieListResponse.Movie) {
            binding.apply {
                this.movieData = item
            }
        }

    }

    companion object {
        private val MOVIE_COMPARATOR = object : DiffUtil.ItemCallback<MovieListResponse.Movie>() {
            override fun areItemsTheSame(
                oldItem: MovieListResponse.Movie,
                newItem: MovieListResponse.Movie
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: MovieListResponse.Movie,
                newItem: MovieListResponse.Movie
            ): Boolean =
                oldItem == newItem
        }
    }

}