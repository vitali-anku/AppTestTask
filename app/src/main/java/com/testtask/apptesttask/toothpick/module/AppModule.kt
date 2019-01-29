package com.testtask.apptesttask.toothpick.module

import android.content.Context
import com.google.gson.Gson
import com.testtask.apptesttask.BuildConfig
import com.testtask.apptesttask.entity.AppConfig
import com.testtask.apptesttask.model.data.server.MarvelService
import com.testtask.apptesttask.model.system.AppSchedulers
import com.testtask.apptesttask.model.system.SchedulersProvider
import com.testtask.apptesttask.presentation.global.ErrorHandler
import com.testtask.apptesttask.toothpick.provider.GsonProvider
import com.testtask.apptesttask.toothpick.provider.MarvelServiceProvider
import com.testtask.apptesttask.toothpick.provider.RetrofitProvider
import retrofit2.Retrofit
import toothpick.config.Module

class AppModule(context: Context) : Module() {
    init {
        //Global
        bind(Context::class.java).toInstance(context)
        bind(AppConfig::class.java).toInstance(
            AppConfig(
                BuildConfig.TS,
                BuildConfig.PUBLIC_KEY,
                BuildConfig.HASH
            )
        )
        bind(SchedulersProvider::class.java).toInstance(AppSchedulers())
        bind(Gson::class.java).toProvider(GsonProvider::class.java).providesSingletonInScope()
        bind(Retrofit::class.java).toProvider(RetrofitProvider::class.java)
                .providesSingletonInScope()
        bind(MarvelService::class.java).toProvider(MarvelServiceProvider::class.java)
                .providesSingletonInScope()

        //Error handler
        bind(ErrorHandler::class.java).singletonInScope()
    }
}