package com.testtask.apptesttask.presentation.favorites

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.testtask.apptesttask.entity.charactrers.Character

@StateStrategyType(AddToEndSingleStrategy::class)
interface FavoritesView : MvpView {

    fun showText(str: String)
    fun showCharacters(characters: List<Character>)
}