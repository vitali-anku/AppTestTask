package com.testtask.apptesttask.presentation.characters

import com.arellomobile.mvp.InjectViewState
import com.testtask.apptesttask.model.interactor.characters.CharactersInteractor
import com.testtask.apptesttask.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class CharactersPresenter @Inject constructor(private val charactersInteractor: CharactersInteractor) :
    BasePresenter<CharactersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadCharacters()
    }

    fun loadCharacters() {
        unsubscribeOnDestroy(charactersInteractor.getCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showProgress() }
                .subscribe({ characterDataWrapper ->
                    viewState.showCharacters(characterDataWrapper.data.results)
                    hideProgress()
                },
                    { error ->
                        viewState.showError(error as Throwable)
                        hideProgress()
                    })
        )
    }

    private fun hideProgress() {
        viewState.hideProgress()
    }
}