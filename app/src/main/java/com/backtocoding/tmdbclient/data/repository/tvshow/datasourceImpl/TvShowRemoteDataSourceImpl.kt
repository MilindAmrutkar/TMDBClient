package com.backtocoding.tmdbclient.data.repository.tvshow.datasourceImpl

import com.backtocoding.tmdbclient.data.api.TMDBService
import com.backtocoding.tmdbclient.data.model.tv.TvShowList
import com.backtocoding.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShowsFromApi(): Response<TvShowList> =
        tmdbService.getPopularTvShows(apiKey)
}