package com.zhalz.eventy.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Division(
    val id: Int,
    val title: String,
    val color: Int,
    val coordinator: String,
    val team: List<Person>? = null,
    val task: List<Task>? = null,
) : Parcelable