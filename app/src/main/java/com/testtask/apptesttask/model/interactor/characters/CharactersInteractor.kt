package com.testtask.apptesttask.model.interactor.characters

import com.testtask.apptesttask.entity.charactrers.CharacterDataWrapper
import io.reactivex.Completable
import io.reactivex.Single

class CharactersInteractor {

    fun getCharacters(): Single<CharacterDataWrapper> {
        TODO("characters interactor (Add implementation returned value method).")
    }

    fun setFavoritCharacter(id: Int, like: Boolean): Completable {
        if (like)
            return Completable.complete()
        else
            return Completable.error(Throwable())
    }
}