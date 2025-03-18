package com.zhalz.eventy.presentation.auth.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.crocodic.core.extension.tos
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.remote.model.response.AuthResponse
import com.zhalz.eventy.databinding.FragmentLoginBinding
import com.zhalz.eventy.domain.common.ApiResult
import com.zhalz.eventy.utils.extension.closeKeyboard
import com.zhalz.eventy.utils.extension.navigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.fragment = this
        binding?.viewModel = viewModel

        initUI()

    }

    private fun initUI() {
        binding?.btnRegister?.setOnClickListener { toRegister() }
    }

    @SuppressLint("SetTextI18n")
    fun login() = lifecycleScope.launch {
        requireActivity().closeKeyboard()

        binding?.etEmail?.setText("vool1@gmail.com")
        binding?.etPass?.setText("081231231231")

        viewModel.login().collect(loginResult())
    }

    private fun loginResult() = FlowCollector<ApiResult<AuthResponse>> {
        when (it) {
            is ApiResult.Success -> toHome()
            is ApiResult.Error -> {
                loadingDialog?.dismiss()
                context?.tos(it.message.orEmpty())
            }
            is ApiResult.Loading -> loadingDialog?.show("Loading...")
        }
    }

    fun toRegister() = LoginFragmentDirections.actionLoginToRegister().navigate(this)
    fun toHome() = LoginFragmentDirections.actionLoginToHome().navigate(this)

}