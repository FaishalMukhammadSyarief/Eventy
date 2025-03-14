package com.zhalz.eventy.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.crocodic.core.base.fragment.CoreFragment

open class BaseFragment<VB : ViewDataBinding>(@LayoutRes private val layoutRes: Int): CoreFragment<VB>(layoutRes) {
    val bind by lazy { binding ?: throw IllegalStateException("Binding is accessed outside of lifecycle") }
}