package com.zhalz.eventy.domain.model

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comment(
    val person: Person,
    val date: String,
    val comment: String,
) : Parcelable {
    @IgnoredOnParcel
    val name = person.name

    @IgnoredOnParcel
    val image = person.image
}
