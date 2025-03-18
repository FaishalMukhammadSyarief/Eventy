package com.zhalz.eventy.data.remote.model.response

import com.crocodic.core.api.ModelResponse
import com.google.gson.annotations.SerializedName
import com.zhalz.eventy.domain.model.Event

data class EventResponse(

    @field:SerializedName("error")
    val error: Any? = null,

    @field:SerializedName("data")
    val data: List<Event>? = null,

) : ModelResponse()
