package com.zhalz.eventy.presentation.event

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.division2List
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

        binding?.apply {
            fragment = this@EventFragment
            rvDivision.adapter = divisionAdapter
            activity.supportActionBar?.title = args.eventTitle
        }

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                getEvent()
            }
        }

        viewModel.getEvent(args.eventTitle)
    }

    private suspend fun getEvent(): Unit = viewModel.eventState.collect { response ->
        when (response) {
            is ApiResult.Loading -> {  }
            is ApiResult.Error -> showSnackBar(response.message.orEmpty())
            is ApiResult.Success -> response.data?.event?.let {
                binding?.event = it
                viewModel.fetchDivisionList(it.id)
                getDivisionList()
            }
        }
    }

    private suspend fun getDivisionList(): Unit = viewModel.divisionListState.collect {
        when (it) {
            is ApiResult.Loading -> {  }
            is ApiResult.Error -> showSnackBar(it.message.orEmpty())
            is ApiResult.Success -> divisionAdapter.submitList(it.data?.data)
        }
    }

    fun toMember() = findNavController().navigate(R.id.action_event_to_member)
    fun toSpending() = EventFragmentDirections.actionEventToSpending(division2List[0]).navigate(this)
    fun toMeeting() = findNavController().navigate(R.id.action_event_to_meeting)
    fun toReport() = {  }
    private fun toDivision(division: Division) = EventFragmentDirections.actionEventToDivision(division).navigate(this)

}