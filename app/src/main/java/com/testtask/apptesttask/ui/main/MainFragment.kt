package com.testtask.apptesttask.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.presentation.main.MainPresenter
import com.testtask.apptesttask.ui.about_me.ProfileFragment
import com.testtask.apptesttask.ui.characters.CharactersFragment
import com.testtask.apptesttask.ui.global.BaseFragment
import com.testtask.apptesttask.ui.likecharacters.LikeCharactersFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(), MvpView {

    override var layoutRes: Int = R.layout.fragment_main

    private var containRes: Int = R.id.mainContainer

    private var currentTabTag: String = ""

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                    .add(containRes, createFragmentByTag(CHARACTERS), CHARACTERS)
                    .add(containRes, createFragmentByTag(LIKECHARACTERS), LIKECHARACTERS)
                    .add(containRes, createFragmentByTag(PROFILE), PROFILE)
                    .commitNow()
            childFragmentManager.beginTransaction()
                    .hide(findFragmentByTag(PROFILE)!!)
                    .hide(findFragmentByTag(LIKECHARACTERS)!!)
                    .show(findFragmentByTag(CHARACTERS)!!)
                    .commit()
        }
        currentTabTag = savedInstanceState?.getString(KEYSAVESTATE) ?: CHARACTERS
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bottom_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.tab_chatacters -> onBottomMenuItemClick(CHARACTERS)
                R.id.tab_like_chatacters -> onBottomMenuItemClick(LIKECHARACTERS)
                R.id.tab_about_me -> onBottomMenuItemClick(PROFILE)
            }
            true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEYSAVESTATE, currentTabTag)
    }

    private fun onBottomMenuItemClick(tag: String) {
        if (tag != currentTabTag) {
            findFragmentByTag(currentTabTag)?.let {
                findFragmentByTag(tag)?.let { it1 ->
                    childFragmentManager.beginTransaction()
                            .hide(it)
                            .show(it1)
                            .commit()
                    currentTabTag = tag
                }
            }
        }
    }

    private fun findFragmentByTag(tag: String) = when (tag) {
        CHARACTERS -> childFragmentManager.findFragmentByTag(CHARACTERS)
        LIKECHARACTERS -> childFragmentManager.findFragmentByTag(LIKECHARACTERS)
        PROFILE -> childFragmentManager.findFragmentByTag(PROFILE)
        else -> throw UnsupportedOperationException("Oyoyoyoi")
    }

    private fun createFragmentByTag(tag: String): Fragment = when (tag) {
        CHARACTERS -> CharactersFragment()
        LIKECHARACTERS -> LikeCharactersFragment()
        PROFILE -> ProfileFragment()
        else -> throw UnsupportedOperationException("Oyoyoyoi")
    }

    companion object {
        private const val CHARACTERS = "characters"
        private const val LIKECHARACTERS = "like_characters"
        private const val PROFILE = "about_me"
        private const val KEYSAVESTATE = "key_state"
    }
}