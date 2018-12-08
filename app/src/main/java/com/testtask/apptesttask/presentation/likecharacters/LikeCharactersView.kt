package com.testtask.apptesttask.presentation.likecharacters

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface LikeCharactersView :MvpView {
    fun showText(str: String)
}