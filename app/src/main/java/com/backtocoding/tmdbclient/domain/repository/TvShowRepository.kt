package com.backtocoding.tmdbclient.domain.repository

import com.backtocoding.tmdbclient.data.model.tv.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}