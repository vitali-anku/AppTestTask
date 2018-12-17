package com.testtask.apptesttask.ui.characters

import android.widget.TextView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.presentation.characters.CharactersPresenter
import com.testtask.apptesttask.presentation.characters.CharactersView
import com.testtask.apptesttask.ui.global.BaseFragment

class CharactersFragment : BaseFragment(), CharactersView {

    @InjectPresenter
    lateinit var presenter: CharactersPresenter

    override val layoutRes = R.layout.fragment_charcters

    override fun showText(str: String) {
        view!!.findViewById<TextView>(R.id.test_characters).text = str
    }
}