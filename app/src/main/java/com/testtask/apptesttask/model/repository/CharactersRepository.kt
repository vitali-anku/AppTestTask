package com.testtask.apptesttask.model.repository

import com.testtask.apptesttask.entity.AppConfig
import com.testtask.apptesttask.entity.charactrers.CharacterDataWrapper
import com.testtask.apptesttask.model.data.server.MarvelService
import com.testtask.apptesttask.model.system.SchedulersProvider
import io.reactivex.Single
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val marvelService: MarvelService,
    private val appConfig: AppConfig,
    private val schedulers: SchedulersProvider
) {

    fun getCharacters(): Single<CharacterDataWrapper> = marvelService
            .getCharacters(appConfig.ts, appConfig.publicKey, appConfig.hash)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
}