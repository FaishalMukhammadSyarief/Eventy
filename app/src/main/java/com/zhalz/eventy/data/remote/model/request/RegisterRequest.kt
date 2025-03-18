package com.zhalz.eventy.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    val username: String,
    val email: String,
    @field:SerializedName("phone_number")
    val phone: String,
    @field:SerializedName("password")
    val pass: String,
    @field:SerializedName("password_confirmation")
    val passConfirm: String,
)