package com.testtask.apptesttask.model.di.module

import android.content.Context
import android.support.annotation.NonNull
import com.testtask.apptesttask.BuildConfig
import com.testtask.apptesttask.TaskApp
import com.testtask.apptesttask.entity.AppConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: TaskApp) {

    @NonNull
    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideAppConfig(): AppConfig =
            AppConfig(BuildConfig.TS, BuildConfig.PUBLIC_KEY, BuildConfig.HASH)
}