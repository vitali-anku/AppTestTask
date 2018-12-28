package com.testtask.apptesttask.presentation.characters

import com.arellomobile.mvp.InjectViewState
import com.testtask.apptesttask.model.interactor.characters.CharactersInteractor
import com.testtask.apptesttask.presentation.global.BasePresenter
import com.testtask.apptesttask.presentation.global.ErrorHandler
import javax.inject.Inject

@InjectViewState
class CharactersPresenter @Inject constructor(
    private val charactersInteractor: CharactersInteractor,
    private val errorHandle: ErrorHandler
) : BasePresenter<CharactersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadCharacters()
    }

    private fun loadCharacters() {
        charactersInteractor.getCharacters()
                .doAfterTerminate { viewState.hideProgress() }
                .subscribe(
                    {
                        viewState.showCharacters(it.data.results)
                    },
                    {
                        errorHandle.proceed(it) { message -> viewState.showError(message) }
                    })
                .connect()
    }
}