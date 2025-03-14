package com.zhalz.eventy.presentation.custom_view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout
import com.zhalz.eventy.R

class TextLayoutNormal @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null): TextInputLayout(context, attrs) {

    init {
        textValidator()
    }

    private fun textValidator() = addOnEditTextAttachedListener {
        editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validateText(s.toString())
            }
        })
    }

    private fun validateText(text: String) {
        val errorMsg = if (text.isEmpty()) context.getString(R.string.text_empty) else null
        error = errorMsg
    }

}