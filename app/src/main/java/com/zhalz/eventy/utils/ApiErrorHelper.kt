package com.zhalz.eventy.utils

import com.crocodic.core.extension.toObject
import com.google.gson.Gson
import com.zhalz.eventy.data.remote.model.response.ErrorResponse
import com.zhalz.eventy.utils.extension.getErrorMessage
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

fun Throwable.handleError(): String =
    when (this) {
        is HttpException -> {
            val json = response()?.errorBody()?.string().orEmpty()
            val errorResponse = runCatching { json.toObject<ErrorResponse>(Gson()) }.getOrNull()

            errorResponse?.getErrorMessage()?: message.orEmpty()
        }

        is IOException -> message.orEmpty()

        else -> "An unexpected error occurred."

    }.also {
        Timber.e("Exception Occurred: $this::class.java.simpleName")
    }