package com.zhalz.eventy.data.remote.model.response

import com.crocodic.core.api.ModelResponse
import com.google.gson.annotations.SerializedName
import com.zhalz.eventy.domain.model.Division

data class DivisionResponse(

	@field:SerializedName("errors")
	val errors: Any? = null,

	@field:SerializedName("data")
	val data: List<Division?>? = null,

) : ModelResponse()