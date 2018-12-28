package com.testtask.apptesttask.extension

import com.testtask.apptesttask.R
import com.testtask.apptesttask.model.system.ResourceManager
import retrofit2.HttpException
import java.io.IOException

fun Throwable.userMessage(resourceManager: ResourceManager) = when (this) {
    is HttpException -> {
        when (this.code()) {
            401 -> resourceManager.getString(R.string.unauthorized)
            404 -> resourceManager.getString(R.string.not_found_error)
            409 -> resourceManager.getString(R.string.conflict_error)
            500 -> resourceManager.getString(R.string.server_error_error)
            else -> resourceManager.getString(R.string.unknown_error)
        }
    }
    is IOException -> resourceManager.getString(R.string.network_error)
    else -> resourceManager.getString(R.string.unknown_error)
}