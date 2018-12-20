package com.testtask.apptesttask.model.interactor.characters

import com.testtask.apptesttask.entity.charactrers.CharacterDataWrapper
import com.testtask.apptesttask.model.repository.CharactersRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class CharactersInteractor @Inject constructor(private var charactersRepository: CharactersRepository) {

    fun getCharacters(): Single<CharacterDataWrapper> = charactersRepository.getCharacters()

    fun setFavoriteCharacter(id: Int, favorite: Boolean): Completable = Completable.complete()
}