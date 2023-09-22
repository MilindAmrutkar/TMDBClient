package com.backtocoding.tmdbclient.presentation.di.core

import com.backtocoding.tmdbclient.domain.repository.ArtistRepository
import com.backtocoding.tmdbclient.domain.repository.MovieRepository
import com.backtocoding.tmdbclient.domain.repository.TvShowRepository
import com.backtocoding.tmdbclient.domain.usecase.GetArtistsUseCase
import com.backtocoding.tmdbclient.domain.usecase.GetMoviesUseCase
import com.backtocoding.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.backtocoding.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.backtocoding.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.backtocoding.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetAristUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }
}