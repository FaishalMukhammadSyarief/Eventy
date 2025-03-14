package com.zhalz.eventy.presentation.auth.landing

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.crocodic.core.base.activity.NoViewModelActivity
import com.crocodic.core.extension.openActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.databinding.ActivityLandingBinding
import com.zhalz.eventy.presentation.auth.login.LoginActivity
import com.zhalz.eventy.presentation.auth.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingActivity : NoViewModelActivity<ActivityLandingBinding>(R.layout.activity_landing) {
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

    fun toLogin() = openActivity<LoginActivity> { finish() }
    fun toRegister() = openActivity<RegisterActivity> { finish() }

}