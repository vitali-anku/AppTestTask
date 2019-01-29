package com.testtask.apptesttask

import android.app.Application
import com.testtask.apptesttask.toothpick.DI
import com.testtask.apptesttask.toothpick.module.AppModule
import toothpick.Toothpick

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initAppScope()
    }

    private fun initAppScope() {
        Toothpick.openScope(DI.APP_SCOPE).installModules(AppModule(this))
    }
}