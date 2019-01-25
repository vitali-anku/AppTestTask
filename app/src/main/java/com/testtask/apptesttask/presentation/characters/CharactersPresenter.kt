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
                .doOnSubscribe { viewState.showProgress() }
                .doAfterTerminate { viewState.hideProgress() }
                .subscribe(
                    {
                        viewState.showCharacters(it)
                        characters.addAll(it)
                    },
                    { errorHandle.proceed(it) { message -> viewState.showError(message) } }
                )
                .connect()
    }

    fun favoritCharacter(position: Int) {
        charactersInteractor.favorCharacter(characters[position])
                .subscribe(
                    {
                        characters[position] = it
                        viewState.showCharacters(characters)
                    },
                    { errorHandle.proceed(it) { message -> viewState.showError(message) } }
                )
                .connect()
    }
}

