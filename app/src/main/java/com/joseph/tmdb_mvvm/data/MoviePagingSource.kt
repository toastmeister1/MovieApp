package com.joseph.tmdb_mvvm.data

import androidx.hilt.Assisted
import androidx.paging.PagingSource
import com.joseph.tmdb_mvvm.model.MovieListResponse
import com.joseph.tmdb_mvvm.network.MovieListService
import com.joseph.tmdb_mvvm.network.MovieListService.ListType
import javax.inject.Inject

private const val TMDB_STARTING_PAGE_INDEX = 1

class MoviePagingSource @Inject constructor(
    private val service: MovieListService,
    private val type: ListType
) : PagingSource<Int, MovieListResponse.Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieListResponse.Movie> {
        val position = params.key ?: TMDB_STARTING_PAGE_INDEX

        return try {

            val response =
                when (type) {
                    ListType.POPULAR -> {
                        service.fetchPopularMovieList(position)
                    }
                    ListType.UPCOMING -> {
                        service.fetchUpComingMovieList(position)
                    }
                    ListType.TOPRATED -> {
                        service.fetchTopRatedMovieList(position)
                    }
                }

            val movies = response.results
            LoadResult.Page(
                data = movies,
                prevKey = if (position == TMDB_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (movies.isEmpty()) null else position + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

}