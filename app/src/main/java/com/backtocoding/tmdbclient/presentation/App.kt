package com.backtocoding.tmdbclient.presentation

import android.app.Application
import com.backtocoding.tmdbclient.BuildConfig
import com.backtocoding.tmdbclient.presentation.di.Injector
import com.backtocoding.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.backtocoding.tmdbclient.presentation.di.core.AppComponent
import com.backtocoding.tmdbclient.presentation.di.core.AppModule
import com.backtocoding.tmdbclient.presentation.di.core.DaggerAppComponent
import com.backtocoding.tmdbclient.presentation.di.core.NetModule
import com.backtocoding.tmdbclient.presentation.di.core.RemoteDataModule
import com.backtocoding.tmdbclient.presentation.di.movie.MovieSubComponent
import com.backtocoding.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}