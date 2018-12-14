package com.testtask.apptesttask.ui.profile

import com.arellomobile.mvp.presenter.InjectPresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.presentation.profile.ProfilePresenter
import com.testtask.apptesttask.presentation.profile.ProfileView
import com.testtask.apptesttask.ui.global.BaseFragment
import kotlinx.android.synthetic.main.fragment_about_me.*

class ProfileFragment : BaseFragment(), ProfileView {

    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    override val layoutRes: Int
        get() = R.layout.fragment_about_me

    override fun showText(str: String) {
        test_about_me.text = str
    }
}