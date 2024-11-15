package com.zhalz.eventy.presentation.contact

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.activity.NoViewModelActivity
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.databinding.ActivityContactBinding
import com.zhalz.eventy.databinding.ItemContactBinding
import com.zhalz.eventy.domain.model.Person

class ContactActivity : NoViewModelActivity<ActivityContactBinding>(R.layout.activity_contact) {

    private val contactAdapter by lazy {
        ReactiveListAdapter<ItemContactBinding, Person>(R.layout.item_contact)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.contactAdapter = contactAdapter

        val contactList = listOf(
            Person(1092312, "Ikhsandi Saktiawan", "ikhsan@mail.com"),
            Person(1239112, "Fabe Bustanil", "fatichin@mail.com"),
        )

        DividerItemDecoration(this, LinearLayoutManager(this).orientation).also {
            binding.rvContact.addItemDecoration(it)
        }

        contactAdapter.submitList(contactList)

    }
}