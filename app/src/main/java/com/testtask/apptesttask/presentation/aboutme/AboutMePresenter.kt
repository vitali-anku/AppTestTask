package com.testtask.apptesttask.presentation.aboutme

import com.arellomobile.mvp.InjectViewState
import com.testtask.apptesttask.presentation.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class AboutMePresenter @Inject constructor(): BasePresenter<AboutMeView>(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showText("AboutMe")
    }
}