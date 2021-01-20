package com.joseph.tmdb_mvvm.ui.activity.detail

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.joseph.tmdb_mvvm.data.MovieListRepository
import com.joseph.tmdb_mvvm.data.MovieRepository
import com.joseph.tmdb_mvvm.model.Movie
import com.joseph.tmdb_mvvm.model.MovieCredits
import com.joseph.tmdb_mvvm.model.MovieDetail
import com.joseph.tmdb_mvvm.model.MovieList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel @ViewModelInject constructor(
        private val movieRepository: MovieRepository?,
        private val movieListRepository: MovieListRepository,
        @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _movieId = MutableLiveData<Int>()
    val movieId: LiveData<Int>
        get() = _movieId

    private var _movie = MutableLiveData<MovieDetail>()
    val movie: LiveData<MovieDetail>
        get() = _movie

    val genre: LiveData<List<MovieDetail.Genre>>
        get() = _movie.map {
            it.genres
        }

    private var _credits = MutableLiveData<MovieCredits>()
    val credits: LiveData<List<MovieCredits.Cast>>
        get() = _credits.map { it.cast }

    private var _recommendList = MutableLiveData<MovieList>()
    val recommendList: LiveData<List<Movie>>
        get() = _recommendList.map {
            it.results
        }

    init {
        _movieId.value = savedStateHandle.get<Int>("movieId")
        viewModelScope.launch {
            _movie.value = getMovieDetail(movieId.value!!)
            _credits.value = getMovieCredits(movieId.value!!)
            _recommendList.value = getRecommendMovieList(movieId.value!!)
        }
    }

    private suspend fun getMovieDetail(movieId: Int) = withContext(Dispatchers.IO) {
        movieRepository?.getMovieDetail(movieId)
    }

    private suspend fun getMovieCredits(movieId: Int) = withContext(Dispatchers.IO) {
        movieRepository?.getMovieCredits(movieId)
    }

    private suspend fun getRecommendMovieList(movieId: Int) = withContext(Dispatchers.IO) {
        movieListRepository.fetchRecommendMovieList(movieId)
    }

}