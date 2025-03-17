package com.zhalz.eventy.domain.model

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meet (
    val id: Int,
    val title: String,
    val date: String,
    val location: String,
    val attendant: List<Person>,
) : Parcelable {
    @IgnoredOnParcel
    val listImage = attendant.map { it.image }
    @IgnoredOnParcel
    val totalAttendees = attendant.size
}