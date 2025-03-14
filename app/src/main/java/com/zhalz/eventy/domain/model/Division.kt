package com.zhalz.eventy.domain.model

import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Division(
    val id: Int,
    val title: String,
    val description: String,
    @ColorRes val color: Int,
    @DrawableRes val icon: Int,
    val coordinator: String,
    val team: List<Person>? = null,
    val task: List<Task>? = null,
) : Parcelable