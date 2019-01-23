package com.testtask.apptesttask.ui.favorites

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.TaskApp
import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.presentation.favorites.FavoritesPresenter
import com.testtask.apptesttask.presentation.favorites.FavoritesView
import com.testtask.apptesttask.ui.global.BaseFragment
import com.testtask.apptesttask.ui.global.FavoritesCharactersAdapter
import javax.inject.Inject

class FavoritesFragment : BaseFragment(), FavoritesView {

    override val layoutRes = R.layout.fragment_favorites_characters

    private lateinit var recycler: RecyclerView

    private lateinit var adapter: FavoritesCharactersAdapter

    @Inject
    @InjectPresenter
    lateinit var presenter: FavoritesPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        TaskApp.newsComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.recycler_favorites_characters)
        adapter = FavoritesCharactersAdapter(context!!)
        recycler.adapter = adapter
    }

    override fun showError(message: String) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCharacters(characters: List<Character>) {
        adapter.setCharacters(characters)
    }
}
