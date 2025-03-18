package com.zhalz.eventy.presentation.auth.login

import android.os.Bundle
import android.view.View
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentLoginBinding
import com.zhalz.eventy.utils.extension.navigate

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.fragment = this

        initUI()

    }

    private fun initUI() {

    }

    fun toRegister() = LoginFragmentDirections.actionLoginToRegister().navigate(this)
    fun toHome() = LoginFragmentDirections.actionLoginToHome().navigate(this)

}