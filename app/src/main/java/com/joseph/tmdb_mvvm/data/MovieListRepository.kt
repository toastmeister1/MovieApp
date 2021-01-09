package com.joseph.tmdb_mvvm.data

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.joseph.tmdb_mvvm.model.MovieListResponse
import com.joseph.tmdb_mvvm.network.MovieListService
import com.joseph.tmdb_mvvm.util.Constants.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject

class MovieListRepository @Inject constructor(
    private val service: MovieListService
) {
    fun fetchPopularMovieList(): Flow<PagingData<MovieListResponse.Movie>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = {MoviePagingSource(service, MovieListService.ListType.POPULAR)}
        ).flow.flowOn(Dispatchers.IO)
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }
}