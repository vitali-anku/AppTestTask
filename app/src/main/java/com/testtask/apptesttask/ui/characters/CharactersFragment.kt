package com.testtask.apptesttask.ui.characters

import com.arellomobile.mvp.presenter.InjectPresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.presentation.characters.CharactersPresenter
import com.testtask.apptesttask.presentation.characters.CharactersView
import com.testtask.apptesttask.ui.global.BaseFragment
import kotlinx.android.synthetic.main.fragment_charcters.*

class CharactersFragment: BaseFragment(), CharactersView {

    @InjectPresenter
    lateinit var presenter: CharactersPresenter

    override val layoutRes: Int
        get() = R.layout.fragment_charcters

    override fun showText(str: String) {
        test_characters.text = str
    }
}