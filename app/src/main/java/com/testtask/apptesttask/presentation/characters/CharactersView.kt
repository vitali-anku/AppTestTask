package com.testtask.apptesttask.presentation.characters

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.testtask.apptesttask.entity.charactrers.Character

@StateStrategyType(AddToEndSingleStrategy::class)
interface CharactersView : MvpView {

    fun showProgress()
    fun showCharacters(characters: List<Character>)
    fun showError(message: String)
    fun hideProgress()
}