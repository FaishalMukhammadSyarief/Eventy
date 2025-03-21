package com.zhalz.eventy.domain.model

import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName
import com.zhalz.eventy.utils.Constanta.Resource.DEFAULT_COLORS
import com.zhalz.eventy.utils.Constanta.Resource.DEFAULT_ICONS
import kotlinx.parcelize.Parcelize

@Parcelize
data class Division2(
    val id: Int,
    val name: String,
    val description: String,
    @ColorRes val color: Int,
    @DrawableRes val icon: Int,
    val coordinator: String,
    val team: List<Person>? = null,
    val task: List<Task>? = null,
) : Parcelable

@Parcelize
data class Division(

    @field:SerializedName("division")
    val name: String? = null,

    @field:SerializedName("coordinator")
    val coordinator: String? = null,

    @field:SerializedName("total_tasks")
    val totalTasks: Int? = null,

    @field:SerializedName("completed_tasks")
    val completedTasks: Int? = null,

    @field:SerializedName("percentage_completed")
    val percentageCompleted: Int? = null,

    @ColorRes val color: Int? = DEFAULT_COLORS.random(),

    @DrawableRes val icon: Int? = DEFAULT_ICONS.random(),

) : Parcelable