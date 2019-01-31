package com.testtask.apptesttask

import android.app.Application
import com.testtask.apptesttask.toothpick.DI
import com.testtask.apptesttask.toothpick.module.AppModule
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initToothpick()
        initAppScope()
    }

    private fun initToothpick() =
            if (BuildConfig.DEBUG) {
                Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
            } else {
                Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
                FactoryRegistryLocator.setRootRegistry(com.testtask.apptesttask.FactoryRegistry())
                MemberInjectorRegistryLocator.setRootRegistry(com.testtask.apptesttask.MemberInjectorRegistry())
            }

    private fun initAppScope() {
        Toothpick.openScope(DI.APP_SCOPE).installModules(AppModule(this))
    }
}