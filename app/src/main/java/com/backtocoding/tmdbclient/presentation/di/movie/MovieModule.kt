package com.backtocoding.tmdbclient.presentation.di.movie

import com.backtocoding.tmdbclient.domain.usecase.GetMoviesUseCase
import com.backtocoding.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.backtocoding.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}