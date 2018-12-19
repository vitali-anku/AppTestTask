package com.testtask.apptesttask.model.di.module

import com.testtask.apptesttask.model.data.MarvelService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
class ApiModule {

    @Provides
    @Singleton
    fun provideMarvelApi(retrofit: Retrofit): MarvelService {
        return retrofit.create(MarvelService::class.java)
    }
}