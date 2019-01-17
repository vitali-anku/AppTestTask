package com.testtask.apptesttask.model.interactor.characters

import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.model.repository.CharactersRepository
import javax.inject.Inject

class CharactersInteractor @Inject constructor(
    private val charactersRepository: CharactersRepository
) {

    fun getCharacters() = charactersRepository.getCharacters()

    fun favorCharacter(character: Character) = charactersRepository.favorCharacter(character)

    fun getFavoritesCharacters() = charactersRepository.getFavoritesCharacters()
}