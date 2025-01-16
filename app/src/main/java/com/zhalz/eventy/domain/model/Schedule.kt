package com.zhalz.eventy.domain.model

data class Schedule (
    val id: Int,
    val title: String,
    val date: String,
    val place: String,
    val attendant: Int,
    val listImage: List<Int>
)