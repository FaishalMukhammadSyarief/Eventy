package com.zhalz.eventy.presentation.main.create_event

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.divisionList
import com.zhalz.eventy.databinding.FragmentCreateEventBinding
import com.zhalz.eventy.databinding.ItemDivisionBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.utils.extension.addMenu
import com.zhalz.eventy.utils.extension.setDropdown
import com.zhalz.eventy.utils.extension.showMaterialDatePicker

class CreateEventFragment : BaseFragment<FragmentCreateEventBinding>(R.layout.fragment_create_event) {

    private val divisionAdapter by lazy {
        ReactiveListAdapter<ItemDivisionBinding, Division>(R.layout.item_division)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

        addMenu(R.menu.menu_profile) {
            if (it.itemId == R.id.menu_check) {
                findNavController().popBackStack()
                true
            } else false
        }

    }

    private fun initUI() = bind.apply {
        fragment = this@CreateEventFragment

        /*  Date Picker  */
        etStartDate.setOnClickListener {
            showMaterialDatePicker { etStartDate.setText(it) }
        }
        etDueDate.setOnClickListener {
            showMaterialDatePicker { etDueDate.setText(it) }
        }

        /*  Dropdown Menu  */
        val dropdownList = listOf("musIc", "cathE", "foOtBedral")
        atvCategory.setDropdown(dropdownList) {}

        /*  Recycler View  */
        rvDivision.adapter = divisionAdapter.apply {
            submitList(divisionList)
        }
    }

    fun showDialog() = findNavController().navigate(R.id.action_create_event_to_add_division_dialog)
}