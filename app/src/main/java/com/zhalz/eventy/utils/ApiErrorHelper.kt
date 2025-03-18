package com.zhalz.eventy.utils

import com.crocodic.core.extension.toObject
import com.google.gson.Gson
import com.zhalz.eventy.data.remote.model.response.ErrorResponse
import retrofit2.HttpException
import java.io.IOException

fun Throwable.handleError(): String =
    when (this) {
        is HttpException -> {
            val stringJson = response()?.errorBody()?.string().orEmpty()
            val errorResponse = stringJson.toObject<ErrorResponse>(Gson())

            errorResponse.getErrorMessage() ?: errorResponse.message ?: "Unexpected HTTP Error."
        }
        is IOException -> {
            println("IO Exception " + this.message)
            "Internet Problem."
        }
        else -> "An unexpected error occurred."
    }

fun ErrorResponse.getErrorMessage(): String? =
    when (errors) {
        is Map<*, *> -> {
            errors.flatMap { (_, value) ->
                (value as List<*>).filterIsInstance<String>()
            }.joinToString("\n")
        }
        is String -> errors
        else -> null
    }
