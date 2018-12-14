package com.testtask.apptesttask.model.repository

import com.testtask.apptesttask.entity.charactrers.CharacterDataWrapper
import com.testtask.apptesttask.model.data.MarvelApi
import io.reactivex.Single

class MarvelRepository(private val marvelApi: MarvelApi) {

    fun getHeroesList(
        ts: String,
        publicKey: String,
        hash: String
    ): Single<CharacterDataWrapper> {
        return marvelApi.getHeroesList(ts, publicKey, hash)
    }
}