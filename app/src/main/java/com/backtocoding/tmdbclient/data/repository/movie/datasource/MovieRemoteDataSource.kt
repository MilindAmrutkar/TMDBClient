package com.backtocoding.tmdbclient.data.repository.movie.datasource

import com.backtocoding.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}