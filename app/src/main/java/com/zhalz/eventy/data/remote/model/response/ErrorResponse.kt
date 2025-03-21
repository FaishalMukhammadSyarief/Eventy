package com.zhalz.eventy.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("errors")
    val errors: Any? = null,

)