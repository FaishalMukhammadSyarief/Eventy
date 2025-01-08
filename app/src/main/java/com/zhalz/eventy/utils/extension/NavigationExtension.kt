package com.zhalz.eventy.utils.extension

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun NavDirections.navigate(fragment: Fragment) {
    fragment.findNavController().navigate(this)
}