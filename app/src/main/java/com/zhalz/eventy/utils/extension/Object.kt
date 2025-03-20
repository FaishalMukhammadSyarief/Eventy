package com.zhalz.eventy.utils.extension

import com.zhalz.eventy.data.remote.model.response.ErrorResponse
import timber.log.Timber
import kotlin.collections.component1
import kotlin.collections.component2

fun ErrorResponse.getErrorMessage(): String? =
    when (errors) {
        is Map<*, *> -> {
            errors.flatMap { (_, value) ->
                (value as List<*>).filterIsInstance<String>()
            }.joinToString("\n")
        }
        is String -> errors
        else -> {
            Timber.w("The actual type is: ${errors.printType()}")
            message
        }
    }

inline fun <reified T> T?.printType(): String =
    if (this == null) "Type: null"
    else "Type: ${this::class.simpleName}"