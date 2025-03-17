package com.zhalz.eventy.domain.model

import android.os.Parcelable
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
) : Parcelable {
    @IgnoredOnParcel
    val listImage = assignee.map { it.image }
}

enum class TaskStatus {
    UNCOMPLETED,
    ON_PROGRESS,
    COMPLETED
}