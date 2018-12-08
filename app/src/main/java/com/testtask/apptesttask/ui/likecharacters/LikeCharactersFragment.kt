package com.testtask.apptesttask.ui.likecharacters

import com.arellomobile.mvp.presenter.InjectPresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.presentation.likecharacters.LikeCharactersPresenter
import com.testtask.apptesttask.presentation.likecharacters.LikeCharactersView
import com.testtask.apptesttask.ui.global.BaseFragment
import kotlinx.android.synthetic.main.fragment_like_characters.*

class LikeCharactersFragment: BaseFragment(), LikeCharactersView {
    override val layoutRes: Int
        get() = R.layout.fragment_like_characters

    @InjectPresenter
    lateinit var presenter: LikeCharactersPresenter

    override fun showText(str: String) {
        test_like_characters.text = str
    }
}