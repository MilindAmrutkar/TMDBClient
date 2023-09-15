package com.backtocoding.tmdbclient.data.repository.artist.datasourceImpl

import com.backtocoding.tmdbclient.data.api.TMDBService
import com.backtocoding.tmdbclient.data.model.artist.ArtistList
import com.backtocoding.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey)
    }

}