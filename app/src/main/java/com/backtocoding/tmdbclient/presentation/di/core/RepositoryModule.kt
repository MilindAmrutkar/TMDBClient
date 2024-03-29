package com.backtocoding.tmdbclient.presentation.di.core

import com.backtocoding.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.backtocoding.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.backtocoding.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.backtocoding.tmdbclient.data.repository.artist.datasourceImpl.ArtistRepositoryImpl
import com.backtocoding.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.backtocoding.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.backtocoding.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.backtocoding.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.backtocoding.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.backtocoding.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.backtocoding.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.backtocoding.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.backtocoding.tmdbclient.domain.repository.ArtistRepository
import com.backtocoding.tmdbclient.domain.repository.MovieRepository
import com.backtocoding.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowLocalDataSource, tvShowRemoteDataSource, tvShowCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource, artistCacheDataSource, artistLocalDataSource
        )
    }
}