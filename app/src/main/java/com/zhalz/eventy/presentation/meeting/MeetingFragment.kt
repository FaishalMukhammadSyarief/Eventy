package com.zhalz.eventy.presentation.meeting

import android.os.Bundle
import android.view.View
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentMeetingBinding

class MeetingFragment : BaseFragment<FragmentMeetingBinding>(R.layout.fragment_meeting) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind.fragment = this

    }

}