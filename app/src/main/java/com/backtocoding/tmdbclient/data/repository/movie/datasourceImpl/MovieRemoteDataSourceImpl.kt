package com.backtocoding.tmdbclient.data.repository.movie.datasourceImpl

import com.backtocoding.tmdbclient.data.api.TMDBService
import com.backtocoding.tmdbclient.data.model.movie.MovieList
import com.backtocoding.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovie(apiKey)

}