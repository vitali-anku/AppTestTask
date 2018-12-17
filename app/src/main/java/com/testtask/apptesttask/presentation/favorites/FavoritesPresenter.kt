package com.testtask.apptesttask.presentation.favorites

import com.arellomobile.mvp.InjectViewState
import com.testtask.apptesttask.presentation.base.BasePresenter

@InjectViewState
class FavoritesPresenter : BasePresenter<FavoritesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        // TODO: like characters tab
        viewState.showText("LikeCharacters")
    }
}