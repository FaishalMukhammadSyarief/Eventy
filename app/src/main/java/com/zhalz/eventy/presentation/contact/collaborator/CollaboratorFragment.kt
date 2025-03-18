package com.zhalz.eventy.presentation.contact.collaborator

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.teamList
import com.zhalz.eventy.databinding.FragmentCollaboratorBinding
import com.zhalz.eventy.databinding.ItemContactBinding
import com.zhalz.eventy.domain.model.Person
import com.zhalz.eventy.presentation.contact.ContactFragmentDirections
import com.zhalz.eventy.utils.extension.navigate

class CollaboratorFragment : BaseFragment<FragmentCollaboratorBinding>(R.layout.fragment_collaborator) {

    private val contactAdapter by lazy {
        ReactiveListAdapter<ItemContactBinding, Person>(R.layout.item_contact).initItem { _, data -> toDetail(data) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.collaboratorAdapter = contactAdapter

        DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation).also {
            binding?.rvCollaborator?.addItemDecoration(it)
        }

        contactAdapter.submitList(teamList)

    }

    private fun toDetail(person: Person) = ContactFragmentDirections.actionContactToProfile(person).navigate(this)

}