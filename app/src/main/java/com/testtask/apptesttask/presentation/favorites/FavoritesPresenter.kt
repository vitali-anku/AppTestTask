package com.testtask.apptesttask.presentation.favorites

import com.arellomobile.mvp.InjectViewState
import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.model.interactor.characters.CharactersInteractor
import com.testtask.apptesttask.presentation.global.BasePresenter
import com.testtask.apptesttask.presentation.global.ErrorHandler
import javax.inject.Inject

@InjectViewState
class FavoritesPresenter @Inject constructor(
    private val charactersInteractor: CharactersInteractor,
    private val errorHandle: ErrorHandler
) : BasePresenter<FavoritesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadFavoritesCharacters()
    }

    private fun loadFavoritesCharacters() {
        charactersInteractor.getFavoritesCharacters()
                .subscribe(
                    {
                        val characters = mutableListOf<Character>()
                        for (id in it.keys) {
                            characters.add(it[id]!!)
                        }
                        viewState.showCharacters(characters)
                    },
                    {
                        errorHandle.proceed(it) { message -> viewState.showError(message) }
                    })
                .connect()
    }
}