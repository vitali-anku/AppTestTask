package com.testtask.apptesttask.model.interactor.characters

import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.model.repository.CharactersRepository
import io.reactivex.Single
import javax.inject.Inject

class CharactersInteractor @Inject constructor(
    private val charactersRepository: CharactersRepository
) {

    fun getCharacters(): Single<List<Character>> = charactersRepository.getCharacters()

    fun setFavoriteCharacter(character: Character): Single<Character> =
            charactersRepository.favorCharacter(character)
}