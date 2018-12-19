package com.testtask.apptesttask.model.interactor.characters

import com.testtask.apptesttask.entity.charactrers.CharacterDataWrapper
import io.reactivex.Single

interface Interactor {
    //TODO characters interactor (Add implementation get characters).
    fun getCharacters(ts: String, apikey: String, hash: String): Single<CharacterDataWrapper>

    fun setFavoritesCharacters(id: Int)
}