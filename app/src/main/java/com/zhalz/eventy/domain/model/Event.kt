package com.zhalz.eventy.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(

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
    val image: String? = null,

//    @field:SerializedName("attachments")
//    val attachments: List<String?>? = null,

    val divisionList: List<Division2>,

    val managerList: List<Person>,

    val coordinatorList: List<Person>,

    val memberList: List<Person>,

    ) : Parcelable
