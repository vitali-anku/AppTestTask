package com.testtask.apptesttask.toothpick.provider

import com.testtask.apptesttask.model.data.server.MarvelService
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Provider

class MarvelServiceProvider @Inject constructor(private val retrofit: Retrofit) : Provider<MarvelService> {

    override fun get(): MarvelService = retrofit.create(MarvelService::class.java)
}