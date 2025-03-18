package com.zhalz.eventy.presentation.auth.register

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.crocodic.core.extension.tos
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentRegisterBinding
import com.zhalz.eventy.domain.common.ApiResult
import com.zhalz.eventy.utils.extension.closeKeyboard
import com.zhalz.eventy.utils.extension.navigate
import com.zhalz.eventy.utils.extension.showSnackBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(R.layout.fragment_register) {

    private val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.fragment = this
        binding?.viewModel = viewModel

        initUI()

    }

    private fun initUI() {
        binding?.btnLogin?.setOnClickListener { toLogin() }
    }

    @SuppressLint("SetTextI18n")
    fun register() = lifecycleScope.launch {
        requireActivity().closeKeyboard()

        val pass = "081231231212"
        
        binding?.etUsername?.setText("Vool12")
        binding?.etEmail?.setText("vool12@gmail.com")
        binding?.etPhone?.setText(pass)
        binding?.etPass?.setText(pass)
        binding?.etPassConfirm?.setText(pass)

        viewModel.register().collect {
            when (it) {
                is ApiResult.Success -> {
                    requireActivity().showSnackBar("Register success, verifying OTP")
                    loadingDialog?.dismiss()
                    verifyOtp(it.data?.authData?.otp ?: 0)
                }
                is ApiResult.Error -> {
                    loadingDialog?.dismiss()
                    context?.tos(it.message.orEmpty())
                }
                is ApiResult.Loading -> loadingDialog?.show("Registering...")
            }
        }
    }

    fun verifyOtp(otp: Int) = lifecycleScope.launch {
        viewModel.verifyOtp(otp).collect {
            when (it) {
                is ApiResult.Success -> {
                    requireActivity().showSnackBar("OTP verification success")
                    toLogin()
                }
                is ApiResult.Error -> {
                    loadingDialog?.dismiss()
                    context?.tos(it.message.orEmpty())
                }
                is ApiResult.Loading -> loadingDialog?.show("Verifying...")
            }
        }
    }

    fun toLogin() = RegisterFragmentDirections.actionRegisterToLogin().navigate(this)

}