package com.backtocoding.tmdbclient.presentation.di

import com.backtocoding.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.backtocoding.tmdbclient.presentation.di.movie.MovieSubComponent
import com.backtocoding.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}