package com.testtask.apptesttask.presentation.likecharacters

import com.arellomobile.mvp.InjectViewState
import com.testtask.apptesttask.presentation.base.BasePresenter

@InjectViewState
class LikeCharactersPresenter: BasePresenter<LikeCharactersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showText("LikeCharacters")
    }
}