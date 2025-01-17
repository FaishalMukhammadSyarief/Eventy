package com.zhalz.eventy.utils.extension

import android.content.Context
import com.zhalz.eventy.R
import java.time.LocalDate.now
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.formatDate(pattern: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val outputFormatter = DateTimeFormatter.ofPattern(pattern)

    val dateTime = LocalDateTime.parse(this, inputFormatter)

    return dateTime.format(outputFormatter)
}

fun String.recognizeDate(context: Context, pattern: String): String {
    val inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val outputFormat = DateTimeFormatter.ofPattern(pattern)

    val dateTime = LocalDateTime.parse(this, inputFormat)

    return when (dateTime.toLocalDate()) {
        now() -> context.getString(R.string.today)
        now().plusDays(1) -> context.getString(R.string.tomorrow)
        now().minusDays(1) -> context.getString(R.string.yesterday)
        else -> dateTime.format(outputFormat)
    }
}