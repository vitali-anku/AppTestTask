package com.testtask.apptesttask.model.interactor.characters

import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.model.repository.CharactersRepository
import com.testtask.apptesttask.model.system.SchedulersProvider
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class CharactersInteractor @Inject constructor(
    private val charactersRepository: CharactersRepository,
    private val schedulers: SchedulersProvider
) {

    fun getCharacters(): Single<List<Character>> = charactersRepository.getCharacters()

    fun setFavoriteCharacter(id: Int, character: Character): Completable =
            Completable.fromAction {
                charactersRepository.favorCharacter(id, character)
            }
                    .observeOn(schedulers.ui())
}