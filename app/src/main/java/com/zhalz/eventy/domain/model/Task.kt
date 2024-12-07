package com.zhalz.eventy.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    val id: Int,
    val title: String,
    val date: String,
    val author: String,
    val team: List<Person>,
) : Parcelable