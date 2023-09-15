package com.backtocoding.tmdbclient.domain.usecase

import com.backtocoding.tmdbclient.data.model.tv.TvShow
import com.backtocoding.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}