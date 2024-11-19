package com.zhalz.eventy.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val id: Int,
    val title: String,
    val date: String,
    val role: String,
    val place: String,
    val category: String,
    val divisionList: List<Division>,
    val managerList: List<Person>,
    val coordinatorList: List<Person>,
    val memberList: List<Person>,
) : Parcelable
