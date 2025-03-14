package com.zhalz.eventy.presentation.custom_view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout
import com.zhalz.eventy.R

class TextLayoutPassword @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null): TextInputLayout(context, attrs) {

    init {
        passwordValidator()
    }

    private fun passwordValidator() = addOnEditTextAttachedListener {
        editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validatePassword(s.toString())
            }
        })
    }

    private fun validatePassword(password: String) {
        error =
            if (password.isEmpty()) context.getString(R.string.password_empty)
            else if (password.length < 8) context.getString(R.string.password_error)
            else null
    }

}