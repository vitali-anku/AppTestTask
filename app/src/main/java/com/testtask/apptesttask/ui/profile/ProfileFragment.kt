package com.testtask.apptesttask.ui.profile

import android.os.Bundle
import android.view.View
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

    lateinit var profoliteText: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profoliteText = view.findViewById(R.id.test_about_me)
    }

    override fun showText(str: String) {
        profoliteText.text = str
    }
}