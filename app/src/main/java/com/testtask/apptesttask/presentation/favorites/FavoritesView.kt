package com.testtask.apptesttask.presentation.favorites

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface FavoritesView : MvpView {

    fun showText(str: String)
}