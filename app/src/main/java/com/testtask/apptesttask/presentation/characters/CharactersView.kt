package com.testtask.apptesttask.presentation.characters

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface CharactersView : MvpView {

    fun showProgress()
    fun showCharacters()
    fun hideProgress()
    fun showMessage(error: Throwable)
}