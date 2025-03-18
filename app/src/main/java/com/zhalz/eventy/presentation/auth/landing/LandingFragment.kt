package com.zhalz.eventy.presentation.auth.landing

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentLandingBinding
import com.zhalz.eventy.utils.extension.navigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.getValue

@AndroidEntryPoint
class LandingFragment : BaseFragment<FragmentLandingBinding>(R.layout.fragment_landing) {

    private val viewModel: LandingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.fragment = this

        initUI()

    }

    private fun initUI() {
        checkUser()
    }

    private fun checkUser() = lifecycleScope.launch {
        loadingDialog?.show("Checking Session...")
        viewModel.getUserSession().second?.let {
            if (it) toHome()
            else viewModel.clearUser()
        }
        loadingDialog?.dismiss()
    }

    fun toLogin() = LandingFragmentDirections.actionLandingToLogin().navigate(this)
    fun toRegister() = LandingFragmentDirections.actionLandingToRegister().navigate(this)
    fun toHome() = LandingFragmentDirections.actionLandingToHome().navigate(this)

}