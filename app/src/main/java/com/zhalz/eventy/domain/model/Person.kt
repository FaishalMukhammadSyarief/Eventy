package com.zhalz.eventy.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person (
    val id: Int,
    val name: String,
    val image: String,
    val email: String,
    val phone: String,
    val otp: Int,
) : Parcelable