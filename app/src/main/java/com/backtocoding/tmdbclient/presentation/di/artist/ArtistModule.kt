package com.backtocoding.tmdbclient.presentation.di.artist

import com.backtocoding.tmdbclient.domain.usecase.GetArtistsUseCase
import com.backtocoding.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.backtocoding.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}