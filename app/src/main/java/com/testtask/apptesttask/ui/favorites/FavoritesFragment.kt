package com.testtask.apptesttask.ui.favorites

import android.widget.TextView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.presentation.favorites.FavoritesPresenter
import com.testtask.apptesttask.presentation.favorites.FavoritesView
import com.testtask.apptesttask.ui.global.BaseFragment

class FavoritesFragment : BaseFragment(), FavoritesView {

    @InjectPresenter
    lateinit var presenter: FavoritesPresenter

    override val layoutRes = R.layout.fragment_like_characters

    override fun showText(str: String) {
        view!!.findViewById<TextView>(R.id.test_like_characters).text = str
    }
}