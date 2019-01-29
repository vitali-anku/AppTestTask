package com.testtask.apptesttask.ui.characters

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.presentation.characters.CharactersPresenter
import com.testtask.apptesttask.presentation.characters.CharactersView
import com.testtask.apptesttask.toothpick.DI
import com.testtask.apptesttask.ui.global.BaseFragment
import com.testtask.apptesttask.ui.global.CharactersAdapter
import toothpick.Toothpick

class CharactersFragment : BaseFragment(), CharactersView, SwipeRefreshLayout.OnRefreshListener {

    override val layoutRes = R.layout.fragment_charcters

    private lateinit var recycler: RecyclerView

    private lateinit var adapter: CharactersAdapter

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    @InjectPresenter
    lateinit var charactersPresenter: CharactersPresenter

    @ProvidePresenter
    fun providePresenter(): CharactersPresenter =
            Toothpick
                    .openScope(DI.APP_SCOPE)
                    .getInstance(CharactersPresenter::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.recycler_characters)
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_characters)
        swipeRefreshLayout.setOnRefreshListener(this)
        adapter = CharactersAdapter(context!!) { charactersPresenter.favoritCharacter(it) }
        recycler.adapter = adapter
    }

    override fun showProgress() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun showCharacters(characters: List<Character>) {
        adapter.setCharacters(characters)
    }

    override fun onRefresh() {
        charactersPresenter.loadCharacters()
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun hideProgress() {
        swipeRefreshLayout.isRefreshing = false
    }
}
