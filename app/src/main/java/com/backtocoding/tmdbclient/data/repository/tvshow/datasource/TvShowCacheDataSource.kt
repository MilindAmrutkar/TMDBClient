package com.backtocoding.tmdbclient.data.repository.tvshow.datasource

import com.backtocoding.tmdbclient.data.model.tv.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}