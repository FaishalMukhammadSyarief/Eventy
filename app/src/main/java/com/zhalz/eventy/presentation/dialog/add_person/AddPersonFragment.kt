package com.zhalz.eventy.presentation.dialog.add_person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.data.teamList
import com.zhalz.eventy.databinding.FragmentAddPersonBinding
import com.zhalz.eventy.databinding.ItemAddContactBinding
import com.zhalz.eventy.domain.model.Person

class AddPersonFragment : DialogFragment() {

    private var _binding: FragmentAddPersonBinding? = null
    private val binding get() = _binding!!

    private val personAdapter by lazy {
        ReactiveListAdapter<ItemAddContactBinding, Person>(R.layout.item_add_contact)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_person, container, false)

        binding.adapter = personAdapter

        DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation).also {
            binding.rvPerson.addItemDecoration(it)
        }

        personAdapter.submitList(teamList)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        dialog?.window?.apply {
            val marginHorizontal = resources.getDimensionPixelSize(R.dimen.margin_dialog)
            val screenWidth = resources.displayMetrics.widthPixels

            setLayout(screenWidth - 2 * marginHorizontal, WRAP_CONTENT)
            setBackgroundDrawableResource(R.drawable.bg_slightly_round)
            setElevation(18f)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}