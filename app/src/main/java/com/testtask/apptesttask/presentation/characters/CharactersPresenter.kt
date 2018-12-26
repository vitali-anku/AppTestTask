package com.testtask.apptesttask.presentation.characters

import com.arellomobile.mvp.InjectViewState
import com.testtask.apptesttask.model.interactor.characters.CharactersInteractor
import com.testtask.apptesttask.model.system.SchedulersProvider
import com.testtask.apptesttask.presentation.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class CharactersPresenter @Inject constructor(
    private var charactersInteractor: CharactersInteractor,
    private var schedulersProvider: SchedulersProvider
) : BasePresenter<CharactersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadCharacters()
    }

    private fun loadCharacters() {
        charactersInteractor
                .getCharacters()
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .doOnSubscribe { viewState.showProgress() }
                .doAfterTerminate { viewState.hideProgress() }
                .subscribe(
                    { characterDataWrapper ->
                        viewState.showCharacters(characterDataWrapper.data.results)
                    },
                    { errorMessage ->
                        viewState.showError(errorMessage.toString())
                    })
                .unsubscribeOnDestroy()
    }
}