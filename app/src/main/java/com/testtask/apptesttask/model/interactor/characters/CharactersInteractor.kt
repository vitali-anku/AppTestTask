package com.testtask.apptesttask.model.interactor.characters

import com.testtask.apptesttask.entity.charactrers.CharacterDataWrapper
import io.reactivex.Completable
import io.reactivex.Single

class CharactersInteractor {

    fun getCharacters(): Single<CharacterDataWrapper> = Single.never()

    fun setFavoriteCharacter(id: Int, favorite: Boolean): Completable = Completable.complete()
}