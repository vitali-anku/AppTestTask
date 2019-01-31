package com.testtask.apptesttask.ui

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.testtask.apptesttask.R
import com.testtask.apptesttask.toothpick.DI
import com.testtask.apptesttask.ui.main.MainFragment
import toothpick.Toothpick

class AppActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScope(DI.APP_SCOPE))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_container)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment())
                    .commitNow()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Toothpick.closeScope(DI.APP_SCOPE)
    }
}
