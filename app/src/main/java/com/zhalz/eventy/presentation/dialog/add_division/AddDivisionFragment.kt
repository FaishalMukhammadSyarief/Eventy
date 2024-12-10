package com.zhalz.eventy.presentation.dialog.add_division

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.zhalz.eventy.R
import com.zhalz.eventy.databinding.FragmentAddDivisionBinding

class AddDivisionFragment : DialogFragment() {

    private var _binding: FragmentAddDivisionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_division, container, false)

        binding.dialog = this

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        dialog?.window?.apply {
            val marginHorizontal = resources.getDimensionPixelSize(R.dimen.margin_dialog)
            val screenWidth = resources.displayMetrics.widthPixels

            setLayout(screenWidth - 2 * marginHorizontal, WRAP_CONTENT)

            setBackgroundDrawableResource(R.drawable.bg_slightly_round)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}