package com.testtask.apptesttask.presentation.characters

import com.arellomobile.mvp.MvpView

interface CharactersView : MvpView {

    fun showText(str: String)
}