package com.testtask.apptesttask.presentation.aboutme

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface ProfileView: MvpView{
    fun showText(str: String)
}