package com.zhalz.eventy.presentation.division

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentDivisionBinding
import com.zhalz.eventy.presentation.division.task.TaskFragment
import com.zhalz.eventy.utils.extension.setupTabLayout

class DivisionFragment : BaseFragment<FragmentDivisionBinding>(R.layout.fragment_division) {

    private val args by navArgs<DivisionFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind.division = args.division

        initUI()

    }

    private fun initUI() {
        setupTabLayout(
            binding?.viewPager,
            binding?.tabLayout,
            listOf(TaskFragment(), TaskFragment(), TaskFragment()),
            listOf("TASK", "IN PROGRESS", "COMPLETED")
        )
    }

}