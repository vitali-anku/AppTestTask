package com.testtask.apptesttask.ui.favorites

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.presentation.favorites.FavoritesPresenter
import com.testtask.apptesttask.presentation.favorites.FavoritesView
import com.testtask.apptesttask.ui.global.BaseFragment

class FavoritesFragment : BaseFragment(), FavoritesView {
    @InjectPresenter
    lateinit var presenter: FavoritesPresenter

    override val layoutRes = R.layout.fragment_like_characters

    private lateinit var likeCharactersText: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        likeCharactersText = view.findViewById(R.id.test_like_characters)
    }

    override fun showError(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCharacters(characters: List<Character>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
