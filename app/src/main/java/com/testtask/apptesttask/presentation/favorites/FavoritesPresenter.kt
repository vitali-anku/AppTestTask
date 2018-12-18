package com.testtask.apptesttask.presentation.favorites

import com.arellomobile.mvp.InjectViewState
import com.testtask.apptesttask.model.interactor.characters.CharactersInteractor
import com.testtask.apptesttask.presentation.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class FavoritesPresenter @Inject constructor(var charactersInteractor: CharactersInteractor) :
    BasePresenter<FavoritesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        // TODO: like characters tab (Add view implementation).
    }
}