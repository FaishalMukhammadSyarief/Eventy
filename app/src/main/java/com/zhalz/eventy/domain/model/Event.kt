package com.zhalz.eventy.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(

    val id: Int,

    @field:SerializedName("title")
    val title: String? = null,

    val description: String? = null,

    @field:SerializedName("start_date")
    val startDate: String? = null,

    @field:SerializedName("end_date")
    val endDate: String? = null,

    val place: String? = null,
    val category: String? = null,
    val divisionList: List<Division>,
    val managerList: List<Person>,
    val coordinatorList: List<Person>,
    val memberList: List<Person>,

) : Parcelable
