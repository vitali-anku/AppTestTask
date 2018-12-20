package com.testtask.apptesttask.model.di.module

import com.testtask.apptesttask.entity.AppConfig
import com.testtask.apptesttask.model.data.MarvelService
import com.testtask.apptesttask.model.repository.CharactersRepository
import dagger.Module
import dagger.Provides

@Module(includes = [ServiceModule::class])
class NetworkModule {

    @Provides
    fun provideMarvelService(marvelService: MarvelService): CharactersRepository =
            CharactersRepository(marvelService, AppConfig())
}