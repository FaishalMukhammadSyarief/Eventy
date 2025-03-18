package com.zhalz.eventy.presentation.auth.landing

import android.os.Bundle
import android.view.View
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentLandingBinding
import com.zhalz.eventy.utils.extension.navigate

class LandingFragment : BaseFragment<FragmentLandingBinding>(R.layout.fragment_landing) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.fragment = this

        initUI()

    }

    private fun initUI() {

    }

    fun toLogin() = LandingFragmentDirections.actionLandingToLogin().navigate(this)
    fun toRegister() = LandingFragmentDirections.actionLandingToRegister().navigate(this)
    //fun toHome() = LandingFragmentDirections.actionLandingToHome().navigate(this)

}