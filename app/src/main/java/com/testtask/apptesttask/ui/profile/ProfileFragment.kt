package com.testtask.apptesttask.ui.profile

import android.widget.TextView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.presentation.profile.ProfilePresenter
import com.testtask.apptesttask.presentation.profile.ProfileView
import com.testtask.apptesttask.ui.global.BaseFragment

class ProfileFragment : BaseFragment(), ProfileView {

    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    override val layoutRes = R.layout.fragment_about_me

    override fun showText(str: String) {
        view!!.findViewById<TextView>(R.id.test_about_me)
    }
}