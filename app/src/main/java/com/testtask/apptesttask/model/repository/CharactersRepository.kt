package com.testtask.apptesttask.model.repository

import com.testtask.apptesttask.entity.AppConfig.Companion.hash
import com.testtask.apptesttask.entity.AppConfig.Companion.publicKey
import com.testtask.apptesttask.entity.AppConfig.Companion.ts
import com.testtask.apptesttask.entity.charactrers.CharacterDataWrapper
import com.testtask.apptesttask.model.data.MarvelService
import io.reactivex.Single

class CharactersRepository(private var marvelService: MarvelService) {

    fun getCharacters(): Single<CharacterDataWrapper> =
            marvelService.getCharacters(ts, publicKey, hash)
}