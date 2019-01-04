package com.testtask.apptesttask.ui.characters

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.TaskApp
import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.presentation.characters.CharactersPresenter
import com.testtask.apptesttask.presentation.characters.CharactersView
import com.testtask.apptesttask.ui.global.BaseFragment
import com.testtask.apptesttask.ui.global.CharactersAdapter
import javax.inject.Inject

class CharactersFragment : BaseFragment(), CharactersView {
    override val layoutRes = R.layout.fragment_charcters

    private lateinit var charactersText: TextView

    private lateinit var adapter: CharactersAdapter

    @Inject
    @InjectPresenter
    lateinit var charactersPresenter: CharactersPresenter

    @ProvidePresenter
    fun providePresenter() = charactersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        TaskApp.newsComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        charactersText = view.findViewById(R.id.test_characters)
    }

    override fun showProgress() {
        //TODO apiCharacters fragment (Add implementation this method).
    }

    override fun showCharacters(characters: List<Character>) {
        adapter = CharactersAdapter(context!!, characters, this)
    }

    override fun favorCharacter(character: Character) {
        charactersPresenter.favoriteCharacter(character, character.favorite)
    }

    override fun showError(message: String) {
        //TODO apiCharacters fragment (Add implementation this method).
    }

    override fun hideProgress() {
        //TODO apiCharacters fragment (Add implementation this method).
    }
}