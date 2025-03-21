package com.zhalz.eventy.data.remote.model.response

import com.crocodic.core.api.ModelResponse
import com.google.gson.annotations.SerializedName
import com.zhalz.eventy.domain.model.Event

data class EventResponse(

    @field:SerializedName("errors")
    val errors: Any? = null,

    @field:SerializedName("data")
    val event: Event? = null,

) : ModelResponse()
