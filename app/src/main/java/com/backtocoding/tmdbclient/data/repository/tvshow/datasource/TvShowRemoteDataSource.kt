package com.backtocoding.tmdbclient.data.repository.tvshow.datasource

import com.backtocoding.tmdbclient.data.model.tv.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShowsFromApi(): Response<TvShowList>
}