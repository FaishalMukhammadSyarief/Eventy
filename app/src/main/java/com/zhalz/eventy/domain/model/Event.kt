package com.zhalz.eventy.domain.model

data class Event(
    val id: Int,
    val title: String,
    val date: String,
    val role: String,
    val place: String,
    val category: String,
)
