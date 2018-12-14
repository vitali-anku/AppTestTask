package com.testtask.apptesttask.ui.characters

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.TaskApp
import com.testtask.apptesttask.model.repository.MarvelRepository
import com.testtask.apptesttask.presentation.characters.CharactersPresenter
import com.testtask.apptesttask.presentation.characters.CharactersView
import com.testtask.apptesttask.ui.global.BaseFragment
import com.testtask.apptesttask.ui.global.CharactersAdapter
import kotlinx.android.synthetic.main.fragment_charcters.*
import java.util.Objects
import javax.inject.Inject

class CharactersFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener, CharactersView {
    override val layoutRes: Int
        get() = R.layout.fragment_charcters

    @InjectPresenter
    lateinit var presenter: CharactersPresenter

    @Inject
    lateinit var marvelRepository: MarvelRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        TaskApp.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    @ProvidePresenter
    fun providePresenter(): CharactersPresenter {
        return CharactersPresenter(marvelRepository)
    }

    override fun showCharacters() {
        initSwipeRefresh()
        initAdapter()
    }

    override fun showMessage(error: Throwable) {
    }

    override fun showProgress() {
        swipe_refresh_characters.isRefreshing = true
    }

    override fun hideProgress() {
        swipe_refresh_characters.isRefreshing = false
    }

    fun initSwipeRefresh() {
        swipe_refresh_characters.setOnRefreshListener(this)
        swipe_refresh_characters.setColorSchemeResources(
            R.color.colorPrimary,
            android.R.color.holo_green_dark,
            android.R.color.holo_orange_dark,
            android.R.color.holo_blue_dark
        )
    }

    override fun onRefresh() {
        presenter.refresh()
    }

    private fun initAdapter() {
        val adapter = CharactersAdapter(presenter)
        recycler_characters.layoutManager = LinearLayoutManager(context)
        recycler_characters.addItemDecoration(
            DividerItemDecoration(
                Objects.requireNonNull(context),
                ConstraintLayout.LayoutParams.VERTICAL
            )
        )
        recycler_characters.adapter = adapter
    }
}