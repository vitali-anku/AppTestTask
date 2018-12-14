package com.testtask.apptesttask.ui

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.testtask.apptesttask.R
import com.testtask.apptesttask.presentation.AppPresenter
import com.testtask.apptesttask.ui.main.MainFragment

class AppActivity : MvpAppCompatActivity(), MvpView {

    @InjectPresenter
    lateinit var presenter: AppPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_container)

        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment()).commit()
        }
    }
}
