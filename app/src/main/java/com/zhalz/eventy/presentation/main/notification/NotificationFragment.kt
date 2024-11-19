package com.zhalz.eventy.presentation.main.notification

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentNotificationBinding
import com.zhalz.eventy.databinding.ItemNotifBinding
import com.zhalz.eventy.domain.model.Notif

class NotificationFragment : BaseFragment<FragmentNotificationBinding>(R.layout.fragment_notification) {

    private val notif7Adapter by lazy {
        ReactiveListAdapter<ItemNotifBinding, Notif>(R.layout.item_notif)
    }

    private val notif30Adapter by lazy {
        ReactiveListAdapter<ItemNotifBinding, Notif>(R.layout.item_notif)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.notif7Adapter = notif7Adapter
        binding?.notif30Adapter = notif30Adapter

        val notif7List = listOf(
            Notif(1, "Music Festival", "Anda memiliki tugas yang belum diselesaikan", "4j"),
            Notif(2, "Music Festival", "Anda memiliki jadwal meeting", "1h"),
        )

        val notif30List = listOf(
            Notif(1, "Music Festival", "Anda memiliki tugas yang belum diselesaikan", "4j"),
            Notif(2, "Music Festival", "Anda memiliki jadwal meeting", "1h"),
        )

        DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation).also {
            binding?.rv7?.addItemDecoration(it)
            binding?.rv30?.addItemDecoration(it)
        }

        notif7Adapter.submitList(notif7List)
        notif30Adapter.submitList(notif30List)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}