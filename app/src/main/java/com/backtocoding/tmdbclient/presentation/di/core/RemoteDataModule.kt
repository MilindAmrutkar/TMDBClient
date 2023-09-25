package com.backtocoding.tmdbclient.presentation.di.core

import com.backtocoding.tmdbclient.BuildConfig
import com.backtocoding.tmdbclient.data.api.TMDBService
import com.backtocoding.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.backtocoding.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.backtocoding.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.backtocoding.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.backtocoding.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.backtocoding.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule() {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }
}