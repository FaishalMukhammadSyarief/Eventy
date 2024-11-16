package com.zhalz.eventy.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Division(
    val id: Int,
    val title: String,
    val color: Int,
    val team: List<Person>,
) : Parcelable
