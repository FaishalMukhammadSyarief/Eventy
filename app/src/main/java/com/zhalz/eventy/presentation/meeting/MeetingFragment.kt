package com.zhalz.eventy.presentation.meeting

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.scheduleList
import com.zhalz.eventy.databinding.FragmentMeetingBinding
import com.zhalz.eventy.databinding.ItemMeetingBinding
import com.zhalz.eventy.domain.model.Schedule
import com.zhalz.eventy.utils.extension.addMenu

class MeetingFragment : BaseFragment<FragmentMeetingBinding>(R.layout.fragment_meeting) {

    private val meetingAdapter by lazy { ReactiveListAdapter<ItemMeetingBinding, Schedule>(R.layout.item_meeting) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind.fragment = this

        initUI()
    }

    private fun initUI() {
        bind.rvMeeting.adapter = meetingAdapter.apply {
            submitList(scheduleList)
        }

        addMenu(R.menu.menu_meeting) {
            when (it.itemId) {
                R.id.menu_add_meeting -> {
                    findNavController().navigate(R.id.action_meeting_to_add_meeting_dialog)
                    true
                }
                else -> false
            }
        }
    }

}