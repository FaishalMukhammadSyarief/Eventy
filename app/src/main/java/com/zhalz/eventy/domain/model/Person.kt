package com.zhalz.eventy.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person (

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("uid")
    val uid: String,

    @field:SerializedName("username")
    val name: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("phone_number")
    val phone: String,

    @field:SerializedName("profile_image")
    val image: String,

) : Parcelable