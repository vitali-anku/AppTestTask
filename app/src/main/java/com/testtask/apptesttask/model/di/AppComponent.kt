package com.testtask.apptesttask.model.di

import android.content.Context
import com.testtask.apptesttask.model.di.module.AppModule
import com.testtask.apptesttask.model.di.module.NetworkModule
import com.testtask.apptesttask.ui.characters.CharactersFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun getContext(): Context

    fun inject(charactersFragment: CharactersFragment)
}