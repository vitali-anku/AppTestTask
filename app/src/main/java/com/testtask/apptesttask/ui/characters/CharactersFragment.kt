package com.testtask.apptesttask.ui.characters

import android.os.Bundle
import android.view.View
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

    private lateinit var charactersText: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        charactersText = view.findViewById(R.id.test_characters)
    }

    override fun showText(str: String) {
        charactersText.text = str
    }
}