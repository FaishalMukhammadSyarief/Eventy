package com.zhalz.eventy.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person (
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val linkedin: String,
    val instagram: String,
    val facebook: String,
) : Parcelable