package com.backtocoding.tmdbclient.domain.repository

import com.backtocoding.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}