package com.backtocoding.tmdbclient.data.repository.artist.datasource

import com.backtocoding.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}