package com.testtask.apptesttask.presentation.characters

import com.arellomobile.mvp.InjectViewState
import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.model.interactor.characters.CharactersInteractor
import com.testtask.apptesttask.presentation.global.BasePresenter
import com.testtask.apptesttask.presentation.global.ErrorHandler
import javax.inject.Inject

@InjectViewState
class CharactersPresenter @Inject constructor(
    private val charactersInteractor: CharactersInteractor,
    private val errorHandle: ErrorHandler
) : BasePresenter<CharactersView>() {

    private val characters = mutableListOf<Character>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadCharacters()
    }

    private fun loadCharacters() {
        charactersInteractor.getCharacters()
                .doAfterTerminate { viewState.hideProgress() }
                .subscribe(
                    {
                        characters.addAll(it)
                        viewState.showCharacters(it)
                    },
                    { errorHandle.proceed(it) { message -> viewState.showError(message) } }
                )
                .connect()
    }

    fun favoritCharacter(position: Int) {
        val character = characters[position].copy(favorite = !characters[position].favorite!!)
        charactersInteractor.setFavoriteCharacter(
            character.id,
            character
        )
        characters.add(position, character)
        viewState.favorCharacter(characters)
    }
}

