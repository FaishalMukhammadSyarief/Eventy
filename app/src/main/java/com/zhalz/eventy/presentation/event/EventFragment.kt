package com.zhalz.eventy.presentation.event

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.crocodic.core.extension.tos
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.divisionList
import com.zhalz.eventy.databinding.FragmentEventBinding
import com.zhalz.eventy.databinding.ItemDivisionBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.utils.extension.navigate

class EventFragment : BaseFragment<FragmentEventBinding>(R.layout.fragment_event) {

    private val args by navArgs<EventFragmentArgs>()

    private val divisionAdapter by lazy {
        ReactiveListAdapter<ItemDivisionBinding, Division>(R.layout.item_division).initItem { _, data -> toDivision(data) }
    }

    private val activity by lazy { requireActivity() as AppCompatActivity }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

    }

    private fun initUI() {
        activity.supportActionBar?.title = args.event.title

        binding?.apply {
            fragment = this@EventFragment
            adapter = divisionAdapter
            event = args.event
        }

        divisionAdapter.submitList(divisionList)
    }

    fun toMember() = findNavController().navigate(R.id.action_event_to_member)
    fun toSpending() = EventFragmentDirections.actionEventToSpending(args.event.divisionList[0]).navigate(this)
    fun toMeeting() = findNavController().navigate(R.id.action_event_to_meeting)
    fun toReport() = context?.tos("rawr")
    private fun toDivision(division: Division) = EventFragmentDirections.actionEventToDivision(division).navigate(this)

}