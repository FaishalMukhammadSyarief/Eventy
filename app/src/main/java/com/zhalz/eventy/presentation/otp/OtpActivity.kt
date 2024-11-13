package com.zhalz.eventy.presentation.otp
import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.crocodic.core.extension.openActivity
import com.crocodic.core.extension.tos
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityOtpBinding
import com.zhalz.eventy.presentation.main.MainActivity
import com.zhalz.eventy.utils.getAnim
import com.zhalz.eventy.utils.setStatusBarColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class OtpActivity : BaseActivity<ActivityOtpBinding, OtpViewModel>(R.layout.activity_otp) {

    private val otpBoxes by lazy { (0 until binding.containerOtp.childCount).map { binding.containerOtp.getChildAt(it) as EditText } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

        initUI()

    }

    private fun initUI() {
        /**  OTP  **/
        otpBoxes.forEachIndexed { i, editText ->
            editText.addTextChangedListener {
                if (it == null) return@addTextChangedListener
                if (it.isNotEmpty() && i < otpBoxes.size - 1) otpBoxes[i + 1].requestFocus()
                if (it.isEmpty() && i > 0) otpBoxes[i - 1].requestFocus()
                if (it.isNotEmpty() && i == otpBoxes.size - 1) binding.btnSend.performClick()
            }
        }
    }

    private fun showSuccessMessage() = binding.screenSuccess.apply {
        setStatusBarColor(TRANSPARENT)
        visibility = VISIBLE
        startAnimation(getAnim(R.anim.anim_slide_up))
    }

    private fun toHome() = lifecycleScope.launch {
        delay(2_000)
        openActivity<MainActivity> { finishAffinity() }
    }

    fun send() {
        if (otpBoxes.all { it.text.toString().isNotEmpty() }) {
            showSuccessMessage()
            toHome()
        }
        else tos(getString(R.string.kode_otp_dibutuhkan))
    }

}