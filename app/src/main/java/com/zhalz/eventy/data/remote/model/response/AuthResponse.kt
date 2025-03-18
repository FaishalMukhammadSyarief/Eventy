package com.zhalz.eventy.data.remote.model.response

import com.crocodic.core.api.ModelResponse
import com.google.gson.annotations.SerializedName
import com.zhalz.eventy.domain.model.Person

data class AuthResponse(

    @field:SerializedName("error")
    val error: Any? = null,

    @field:SerializedName("data")
    val authData: AuthData? = null,

) : ModelResponse()

data class AuthData(

    @field:SerializedName("user")
    val person: Person? = null,

    @field:SerializedName("token")
    val token: String? = null,

    @field:SerializedName("otp")
    val otp: Int? = null

)