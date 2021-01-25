package com.joseph.tmdb_mvvm.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.joseph.tmdb_mvvm.model.Movie
import com.joseph.tmdb_mvvm.network.MovieListService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieListRepository @Inject constructor(
    private val service: MovieListService
) {
    fun fetchPopularMovieList(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { MoviePagingSource(service, MovieListService.ListType.POPULAR) }
        ).flow.flowOn(Dispatchers.IO)
    }

    fun fetchTopRatedMovieList(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { MoviePagingSource(service, MovieListService.ListType.TOPRATED) }
        ).flow.flowOn(Dispatchers.IO)
    }

    fun fetchUpComingMovieList(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { MoviePagingSource(service, MovieListService.ListType.UPCOMING) }
        ).flow.flowOn(Dispatchers.IO)
    }

    suspend fun fetchRecommendMovieList(movieId: Int) = service.fetchRecommandMovieList(movieId)

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }
}
