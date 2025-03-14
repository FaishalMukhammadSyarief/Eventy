package com.zhalz.eventy.presentation.report.division.spending

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.spendingList
import com.zhalz.eventy.databinding.FragmentSpendingBinding
import com.zhalz.eventy.databinding.ItemSpendingBinding
import com.zhalz.eventy.domain.model.Spending

class SpendingFragment : BaseFragment<FragmentSpendingBinding>(R.layout.fragment_spending) {

    private val args by navArgs<SpendingFragmentArgs>()

    private val spendingAdapter by lazy {
        ReactiveListAdapter<ItemSpendingBinding, Spending>(R.layout.item_spending)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.spendingAdapter = spendingAdapter
        binding?.division = args.division

        spendingAdapter.submitList(spendingList)

    }

}