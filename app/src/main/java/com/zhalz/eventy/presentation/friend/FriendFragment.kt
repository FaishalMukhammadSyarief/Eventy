package com.zhalz.eventy.presentation.friend

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentFriendBinding
import com.zhalz.eventy.databinding.ItemContactBinding
import com.zhalz.eventy.domain.model.Person

class FriendFragment : BaseFragment<FragmentFriendBinding>(R.layout.fragment_friend) {

    private val contactAdapter by lazy {
        ReactiveListAdapter<ItemContactBinding, Person>(R.layout.item_contact)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.contactAdapter = contactAdapter

        val contactList = listOf(
            Person(1092312, "Ikhsandi Saktiawan", "ikhsan@mail.com"),
            Person(1239112, "Fabe Bustanil", "fatichin@mail.com"),
        )

        DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation).also {
            binding?.rvContact?.addItemDecoration(it)
        }

        contactAdapter.submitList(contactList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}