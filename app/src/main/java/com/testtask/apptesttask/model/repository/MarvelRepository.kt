package com.testtask.apptesttask.model.repository

import com.testtask.apptesttask.entity.charactrers.CharacterDataWrapper
import com.testtask.apptesttask.model.data.MarvelService
import io.reactivex.Single

class MarvelRepository(private val marvelApi: MarvelService) {

    fun getHeroesList(
        ts: String,
        publicKey: String,
        hash: String
    ): Single<CharacterDataWrapper> = marvelApi.getHeroesList(ts, publicKey, hash)
}