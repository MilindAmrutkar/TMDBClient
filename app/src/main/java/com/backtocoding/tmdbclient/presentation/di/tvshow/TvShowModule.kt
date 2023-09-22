package com.backtocoding.tmdbclient.presentation.di.tvshow

import com.backtocoding.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.backtocoding.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.backtocoding.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}