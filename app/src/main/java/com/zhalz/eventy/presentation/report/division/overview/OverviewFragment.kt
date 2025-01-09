package com.zhalz.eventy.presentation.report.division.overview

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.TIRAMISU
import android.os.Bundle
import android.view.View
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentOverviewBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_DIVISION

class OverviewFragment : BaseFragment<FragmentOverviewBinding>(R.layout.fragment_overview) {

    private val division: Division? by lazy {
        if (SDK_INT >= TIRAMISU) requireActivity().intent.getParcelableExtra(EXTRA_DIVISION, Division::class.java)
        else @Suppress("DEPRECATION") requireActivity().intent.getParcelableExtra(EXTRA_DIVISION)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.division = division

    }

}