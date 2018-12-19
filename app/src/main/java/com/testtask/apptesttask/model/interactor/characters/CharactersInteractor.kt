package com.testtask.apptesttask.model.interactor.characters

import com.testtask.apptesttask.entity.charactrers.CharacterDataWrapper
import io.reactivex.Observable
import io.reactivex.Single

class CharactersInteractor {

    fun getCharacters(): Single<CharacterDataWrapper> {
        return TODO("characters interactor (Add implementation returned value method).")
    }

    fun setFavoritesCharacters(id: Int): Observable<CharacterDataWrapper> {
        return TODO("characters interactor (Add implementation returned value method).")
    }
}