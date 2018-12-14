package com.testtask.apptesttask.model.di.module

import com.testtask.apptesttask.model.data.MarvelApi
import com.testtask.apptesttask.model.repository.MarvelRepository
import dagger.Module
import dagger.Provides

@Module(includes = [ApiModule::class])
class MarvelModule {

    @Provides
    fun provideMarvelService(marvelApi: MarvelApi): MarvelRepository = MarvelRepository(marvelApi)
}