package com.zhalz.eventy.presentation.report.division.spending

import android.os.Build
import android.os.Bundle
import android.view.View
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentSpendingBinding
import com.zhalz.eventy.databinding.ItemSpendingBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.domain.model.Spending
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_DIVISION

class SpendingFragment : BaseFragment<FragmentSpendingBinding>(R.layout.fragment_spending) {

    private val division: Division? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) requireActivity().intent.getParcelableExtra(EXTRA_DIVISION, Division::class.java)
        else @Suppress("DEPRECATION") requireActivity().intent.getParcelableExtra(EXTRA_DIVISION)
    }

    private val spendingAdapter by lazy {
        ReactiveListAdapter<ItemSpendingBinding, Spending>(R.layout.item_spending)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.spendingAdapter = spendingAdapter
        binding?.division = division

        val spendingList = listOf(
            Spending(123, "Makanan", "22 Agustus 2024", 75000),
            Spending(123, "Peralatan", "22 Agustus 2024", 200000),
            Spending(123, "Minuman", "22 Agustus 2024", 75000),
        )

        spendingAdapter.submitList(spendingList)

    }

}