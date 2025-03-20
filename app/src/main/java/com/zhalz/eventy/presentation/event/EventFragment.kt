package com.zhalz.eventy.presentation.event

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.divisionList
import com.zhalz.eventy.databinding.FragmentEventBinding
import com.zhalz.eventy.databinding.ItemDivisionBinding
import com.zhalz.eventy.domain.common.ApiResult
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.utils.extension.navigate
import com.zhalz.eventy.utils.extension.showSnackBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EventFragment : BaseFragment<FragmentEventBinding>(R.layout.fragment_event) {

    private val args by navArgs<EventFragmentArgs>()

    private val viewModel by viewModels<EventViewModel>()

    private val divisionAdapter by lazy {
        ReactiveListAdapter<ItemDivisionBinding, Division>(R.layout.item_division).initItem { _, data -> toDivision(data) }
    }

    private val activity by lazy { requireActivity() as AppCompatActivity }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

    }

    private fun initUI() {

        binding?.apply {
            fragment = this@EventFragment
            adapter = divisionAdapter
            activity.supportActionBar?.title = args.eventTitle
        }

        getEvent(args.eventTitle)
    }

    private fun getEvent(title: String) = lifecycleScope.launch {
        viewModel.getEvent(title).collect {
            when (it) {
                is ApiResult.Success -> {
                    binding?.event = it.data?.event
                    divisionAdapter.submitList(divisionList)
                }

                is ApiResult.Error -> {
                    showSnackBar(it.message.orEmpty())
                }
                is ApiResult.Loading -> {  }
            }
        }
    }

    fun toMember() = findNavController().navigate(R.id.action_event_to_member)
    fun toSpending() = EventFragmentDirections.actionEventToSpending(divisionList[0]).navigate(this)
    fun toMeeting() = findNavController().navigate(R.id.action_event_to_meeting)
    fun toReport() = {  }
    private fun toDivision(division: Division) = EventFragmentDirections.actionEventToDivision(division).navigate(this)

}