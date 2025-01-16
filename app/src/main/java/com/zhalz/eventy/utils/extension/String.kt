package com.zhalz.eventy.utils.extension

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.formatDate(pattern: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    val dateTime = LocalDateTime.parse(this, inputFormatter)

    val outputFormatter = DateTimeFormatter.ofPattern(pattern)

    return dateTime.format(outputFormatter)
}