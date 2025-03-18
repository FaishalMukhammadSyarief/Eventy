package com.zhalz.eventy.data.remote.model.response

import com.crocodic.core.api.ModelResponse
import com.google.gson.annotations.SerializedName
import com.zhalz.eventy.domain.model.Person

data class AuthResponse(

    @field:SerializedName("msg")
    val msg: String? = null,

    @field:SerializedName("error")
    val error: Any? = null,

    @field:SerializedName("data")
    val data: Person? = null,

) : ModelResponse()