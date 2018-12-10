package com.testtask.apptesttask.model.di.module

import android.content.Context
import android.support.annotation.NonNull
import com.testtask.apptesttask.TaskApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule (val app: TaskApp) {
    @NonNull
    @Provides
    @Singleton
    fun provideContext(): Context = app
}