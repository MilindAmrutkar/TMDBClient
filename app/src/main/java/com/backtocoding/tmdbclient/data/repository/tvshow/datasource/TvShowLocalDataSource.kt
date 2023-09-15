package com.backtocoding.tmdbclient.data.repository.tvshow.datasource

import com.backtocoding.tmdbclient.data.model.tv.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}