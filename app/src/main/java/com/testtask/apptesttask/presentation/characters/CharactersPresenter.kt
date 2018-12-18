package com.testtask.apptesttask.presentation.characters

import com.arellomobile.mvp.InjectViewState
import com.testtask.apptesttask.model.interactor.characters.CharactersInteractor
import com.testtask.apptesttask.presentation.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class CharactersPresenter @Inject constructor(var charactersInteractor: CharactersInteractor) :
    BasePresenter<CharactersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        // TODO: characters tab (Add view implementation).
    }
}