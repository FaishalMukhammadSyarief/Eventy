package com.zhalz.eventy.utils

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.zhalz.eventy.R

object Constanta {

    object DataStore {

        object User {
            const val DATA_STORE_NAME = "session"
            const val EMAIL_KEY = "email"
            const val TOKEN_KEY = "token"
            const val NAME_KEY = "name"
            const val REMEMBER_KEY = "remember"
        }

    }

    object Resource {
        @ColorRes
        val DEFAULT_COLORS = listOf(
            R.color.purple,
            R.color.red,
            R.color.pink,
            R.color.orange,
            R.color.yellow,
            R.color.green,
            R.color.blue
        )

        @DrawableRes
        val DEFAULT_ICONS = listOf(
            R.drawable.ic_admin,
            R.drawable.ic_megaphone,
            R.drawable.ic_handshake,
            R.drawable.ic_palette,
            R.drawable.ic_shield,
            R.drawable.ic_truck,
        )
    }

}