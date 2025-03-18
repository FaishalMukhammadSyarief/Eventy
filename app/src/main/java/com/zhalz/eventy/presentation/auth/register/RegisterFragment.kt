package com.zhalz.eventy.presentation.auth.register

import android.os.Bundle
import android.view.View
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentRegisterBinding
import com.zhalz.eventy.utils.extension.navigate

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(R.layout.fragment_register) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.fragment = this

        initUI()

    }

    private fun initUI() {

    }

    fun toLogin() = RegisterFragmentDirections.actionRegisterToLogin().navigate(this)

}