package com.testtask.apptesttask.model.di.module

import com.testtask.apptesttask.model.data.MarvelApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
class ApiModule {

    @Provides
    @Singleton
    fun provideMarvelApi(retrofit: Retrofit): MarvelApi {
        return retrofit.create(MarvelApi::class.java)
    }
}