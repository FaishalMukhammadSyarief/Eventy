package com.zhalz.eventy.presentation.login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.crocodic.core.extension.openActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityLoginBinding
import com.zhalz.eventy.presentation.main.MainActivity
import com.zhalz.eventy.presentation.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

        initUI()

    }

    private fun initUI() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun toRegister() = openActivity<RegisterActivity> { finish() }
    fun toHome() = openActivity<MainActivity> { finish() }

}