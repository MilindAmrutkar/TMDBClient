package com.backtocoding.tmdbclient.domain.usecase

import com.backtocoding.tmdbclient.data.model.artist.Artist
import com.backtocoding.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}