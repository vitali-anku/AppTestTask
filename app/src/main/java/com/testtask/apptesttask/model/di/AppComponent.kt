package com.testtask.apptesttask.model.di

import android.content.Context
import com.testtask.apptesttask.model.di.module.AppModule
import com.testtask.apptesttask.model.di.module.MarveModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, MarveModule::class])
interface AppComponent {

    fun getContext(): Context
}