package com.testtask.apptesttask.model.di.module

import android.content.Context
import android.support.annotation.NonNull
import com.testtask.apptesttask.BuildConfig
import com.testtask.apptesttask.TaskApp
import com.testtask.apptesttask.entity.AppConfig
import com.testtask.apptesttask.model.system.AppSchedulers
import com.testtask.apptesttask.model.system.SchedulersProvider
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

    @Provides
    @Singleton
    fun provideSchedulers(): SchedulersProvider = AppSchedulers()
}