package com.zhalz.eventy.domain.model

import android.os.Parcelable
import com.zhalz.eventy.domain.common.TaskStatus
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val due: String,
    val author: String,
    val assignee: List<Person>,
    val status: TaskStatus,
    val commentList: List<Comment>
) : Parcelable {
    @IgnoredOnParcel
    val listImage = assignee.map { it.image }
}