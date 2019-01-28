package com.testtask.apptesttask.ui.characters

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
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

    private lateinit var recycler: RecyclerView

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

        recycler = view.findViewById(R.id.recycler_characters)
        adapter = CharactersAdapter(context!!) { charactersPresenter.favoritCharacter(it) }
        recycler.adapter = adapter
    }

    override fun showProgress() {
        //TODO apiCharacters fragment (Add implementation this method).
    }

    override fun showCharacters(characters: List<Character>) {
        adapter.setCharacters(characters)
    }

    override fun showError(message: String) {
        //TODO apiCharacters fragment (Add implementation this method).
    }

    override fun hideProgress() {
        //TODO apiCharacters fragment (Add implementation this method).
    }
}