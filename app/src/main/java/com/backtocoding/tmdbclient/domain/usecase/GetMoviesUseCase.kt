package com.backtocoding.tmdbclient.domain.usecase

import com.backtocoding.tmdbclient.data.model.movie.Movie
import com.backtocoding.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}