package com.testtask.apptesttask

import android.app.Application
import com.testtask.apptesttask.model.di.AppComponent
import com.testtask.apptesttask.model.di.DaggerAppComponent
import com.testtask.apptesttask.model.di.module.AppModule

class TaskApp : Application() {

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        lateinit var newsComponent: AppComponent
            private set
    }
}