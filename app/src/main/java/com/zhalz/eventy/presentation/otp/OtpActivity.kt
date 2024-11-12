package com.zhalz.eventy.presentation.otp

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityOtpBinding

class OtpActivity : BaseActivity<ActivityOtpBinding, OtpViewModel>(R.layout.activity_otp) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

        initUI()

        val otpBoxes = (0 until binding.containerOtp.childCount).map { binding.containerOtp.getChildAt(it) as EditText }

        otpBoxes.forEachIndexed { i, editText ->
            editText.addTextChangedListener {
                if (it?.isNotEmpty() == true && i < otpBoxes.size - 1) otpBoxes[i + 1].requestFocus()
                if (it?.isEmpty() == true && i > 0) otpBoxes[i - 1].requestFocus()
                if (it?.isNotEmpty() == true && i == otpBoxes.size - 1) binding.btnSend.requestFocus()
            }
        }
    }

    private fun initUI() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}