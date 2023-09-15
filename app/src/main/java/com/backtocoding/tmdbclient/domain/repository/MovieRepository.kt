package com.backtocoding.tmdbclient.domain.repository

import com.backtocoding.tmdbclient.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}