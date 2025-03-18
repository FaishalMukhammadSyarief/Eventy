package com.zhalz.eventy.presentation.auth.register

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.crocodic.core.extension.tos
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.remote.model.response.AuthResponse
import com.zhalz.eventy.databinding.FragmentRegisterBinding
import com.zhalz.eventy.domain.common.ApiResult
import com.zhalz.eventy.utils.extension.closeKeyboard
import com.zhalz.eventy.utils.extension.navigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.FlowCollector
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

        binding?.etUsername?.setText("Vool1")
        binding?.etEmail?.setText("vool1@gmail.com")
        binding?.etPhone?.setText("081231231231")
        binding?.etPass?.setText("081231231231")
        binding?.etPassConfirm?.setText("081231231231")

        viewModel.register().collect(registerResult())
    }

    private fun registerResult() = FlowCollector<ApiResult<AuthResponse>> {
        when (it) {
            is ApiResult.Success -> {
                context?.tos("Register success, please login to proceed")
                toLogin()
            }
            is ApiResult.Error -> {
                loadingDialog?.dismiss()
                context?.tos(it.message.orEmpty())
            }
            is ApiResult.Loading -> loadingDialog?.show("Loading...")
        }
    }

    fun toLogin() = RegisterFragmentDirections.actionRegisterToLogin().navigate(this)

}