package com.testtask.apptesttask.model.di

import android.content.Context
import com.testtask.apptesttask.ui.characters.CharactersFragment
import javax.inject.Singleton

@Singleton
interface AppComponent {

    fun getContext(): Context

    fun inject(charactersFragment: CharactersFragment)
}