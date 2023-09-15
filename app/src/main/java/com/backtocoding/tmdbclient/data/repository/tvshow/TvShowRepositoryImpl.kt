package com.backtocoding.tmdbclient.data.repository.tvshow

import android.util.Log
import com.backtocoding.tmdbclient.data.model.tv.TvShow
import com.backtocoding.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.backtocoding.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.backtocoding.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.backtocoding.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        var newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShowsFromApi()
            response.body()?.let {
                tvShowsList = it.tvShows
            }
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromLocalDB(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>
        try {
            tvShowsList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        if (tvShowsList.isNotEmpty()) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowsList)
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>
        try {
            tvShowsList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        if (tvShowsList.isNotEmpty()) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromLocalDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowsList)
        }
        return tvShowsList
    }
}