package com.backtocoding.tmdbclient.presentation.di.core

import com.backtocoding.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.backtocoding.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.backtocoding.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.backtocoding.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.backtocoding.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.backtocoding.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }
}