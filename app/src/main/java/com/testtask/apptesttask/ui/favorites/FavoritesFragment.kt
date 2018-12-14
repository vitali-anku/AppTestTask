package com.testtask.apptesttask.ui.favorites

import com.arellomobile.mvp.presenter.InjectPresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.presentation.favorites.FavoritesPresenter
import com.testtask.apptesttask.presentation.favorites.FavoritesView
import com.testtask.apptesttask.ui.global.BaseFragment
import kotlinx.android.synthetic.main.fragment_like_characters.*

class FavoritesFragment: BaseFragment(), FavoritesView {
    override val layoutRes: Int
        get() = R.layout.fragment_like_characters

    @InjectPresenter
    lateinit var presenter: FavoritesPresenter

    override fun showText(str: String) {
        test_like_characters.text = str
    }
}