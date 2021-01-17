package com.joseph.tmdb_mvvm.ui.activity.detail

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.joseph.tmdb_mvvm.data.MovieRepository
import com.joseph.tmdb_mvvm.model.MovieDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class MovieDetailViewModel @ViewModelInject constructor(
    private val repository: MovieRepository?,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _movieId = MutableLiveData<Int>()
    val movieId: LiveData<Int>
        get() = _movieId

    private var _movie = MutableLiveData<MovieDetail>()
    val movie: LiveData<MovieDetail>
        get() = _movie


    init {
        _movieId.value = savedStateHandle.get<Int>("movieId")
        getMovieDetail(movieId.value!!)
    }

    private fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {
            _movie.value = withContext(Dispatchers.IO) {
                repository?.getMovieDetail(movieId)
            }
            Timber.d(_movie.value.toString())
        }
    }
}