package com.joseph.tmdb_mvvm.di

import com.joseph.tmdb_mvvm.data.MovieListRepository
import com.joseph.tmdb_mvvm.network.MovieListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(FragmentComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideMovieListRepository(
        service: MovieListService
    ): MovieListRepository {
        return MovieListRepository(service)
    }

}