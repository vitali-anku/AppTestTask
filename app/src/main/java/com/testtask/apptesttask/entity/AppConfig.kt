package com.testtask.apptesttask.entity

import com.testtask.apptesttask.BuildConfig

class AppConfig {
    companion object {
        const val ts = BuildConfig.TS
        const val publicKey = BuildConfig.PUBLIC_KEY
        const val hash = BuildConfig.HASH
    }
}