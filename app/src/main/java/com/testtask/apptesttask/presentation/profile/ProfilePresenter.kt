package com.testtask.apptesttask.presentation.profile

import com.arellomobile.mvp.InjectViewState
import com.testtask.apptesttask.presentation.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor() : BasePresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showText("AboutMe")
    }
}