package com.zhalz.eventy.presentation.custom_view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Patterns.EMAIL_ADDRESS
import com.google.android.material.textfield.TextInputLayout
import com.zhalz.eventy.R

class TextLayoutEmail @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null): TextInputLayout(context, attrs) {

    init {
        emailValidator()
    }

    private fun emailValidator() = addOnEditTextAttachedListener {
        editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validateEmail(s.toString())
            }
        })
    }

    private fun validateEmail(email: String) {
        error =
            if (email.isEmpty()) context.getString(R.string.email_empty)
            else if (!EMAIL_ADDRESS.matcher(email).matches()) context.getString(R.string.email_error)
            else null
    }

}