package com.backtocoding.tmdbclient.data.repository.artist.datasource

import com.backtocoding.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artist: List<Artist>)

}