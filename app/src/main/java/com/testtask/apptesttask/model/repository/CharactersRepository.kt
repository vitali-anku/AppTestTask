package com.testtask.apptesttask.model.repository

import com.testtask.apptesttask.entity.AppConfig
import com.testtask.apptesttask.entity.charactrers.CharacterDataWrapper
import com.testtask.apptesttask.model.data.MarvelService
import io.reactivex.Single
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val marvelService: MarvelService,
    private val appConfig: AppConfig
) {

    fun getCharacters(): Single<CharacterDataWrapper> =
            marvelService.getCharacters(appConfig.ts, appConfig.publicKey, appConfig.hash)
}