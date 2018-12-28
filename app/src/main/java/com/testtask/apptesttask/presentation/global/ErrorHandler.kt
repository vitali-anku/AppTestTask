package com.testtask.apptesttask.presentation.global

import com.testtask.apptesttask.extension.userMessage
import com.testtask.apptesttask.model.system.ResourceManager
import javax.inject.Inject

class ErrorHandler @Inject constructor(
    private val resourceManager: ResourceManager
) {

    fun proceed(error: Throwable, messageListener: (String) -> Unit = {}) {
        messageListener(error.userMessage(resourceManager))
    }
}