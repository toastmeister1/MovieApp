package com.joseph.tmdb_mvvm.ui.frag.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joseph.tmdb_mvvm.data.MovieListRepository
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val repository: MovieListRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
