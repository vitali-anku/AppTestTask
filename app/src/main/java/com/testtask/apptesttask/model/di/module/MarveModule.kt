package com.testtask.apptesttask.model.di.module

import com.testtask.apptesttask.model.data.MarvelService
import com.testtask.apptesttask.model.interactor.characters.CharactersInteractor
import com.testtask.apptesttask.model.repository.MarvelRepository
import dagger.Module
import dagger.Provides

@Module(includes = [ApiModule::class])
class MarveModule {

    @Provides
    fun provideMarvelService(marvelApi: MarvelService): MarvelRepository =
            MarvelRepository(marvelApi)

    @Provides
    fun provideCharactersInteractoir(marvelRepository: MarvelRepository): CharactersInteractor =
            CharactersInteractor(marvelRepository)
}