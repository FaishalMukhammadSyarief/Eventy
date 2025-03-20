package com.zhalz.eventy.data.remote.model.response

import com.google.gson.annotations.SerializedName
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.domain.model.Person

data class Data(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("start_date")
	val startDate: String? = null,

	@field:SerializedName("end_date")
	val endDate: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("image_path")
	val imagePath: String? = null,

	@field:SerializedName("attachments")
	val attachments: List<Any?>? = null,

	@field:SerializedName("event_handlers")
	val eventHandlers: List<EventHandlersItem?>? = null,

	)

data class EventHandlersItem(

	@field:SerializedName("user")
	val user: Person? = null,

	@field:SerializedName("division")
	val division: Division? = null,

	@field:SerializedName("event_id")
	val eventId: Int? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("division_id")
	val divisionId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

)
