package com.zhalz.eventy.presentation.create_event

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.crocodic.core.extension.tos
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.data.divisionList
import com.zhalz.eventy.databinding.ActivityCreateEventBinding
import com.zhalz.eventy.databinding.ItemDivisionBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.presentation.dialog.add_division.AddDivisionFragment
import com.zhalz.eventy.utils.setDropdown
import com.zhalz.eventy.utils.showMaterialDatePicker

class CreateEventActivity : BaseActivity<ActivityCreateEventBinding, CreateEventViewModel>(R.layout.activity_create_event) {

    private val divisionAdapter by lazy {
        ReactiveListAdapter<ItemDivisionBinding, Division>(R.layout.item_division)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this
        binding.divisionAdapter = divisionAdapter

        setCategory()

        divisionAdapter.submitList(divisionList)

        binding.toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.menu_check) finish()
            true
        }

        binding.etStartDate.setOnClickListener {
            showMaterialDatePicker { binding.etStartDate.setText(it) }
        }

        binding.etDueDate.setOnClickListener {
            showMaterialDatePicker { binding.etDueDate.setText(it) }
        }

    }

    private fun setCategory() {
        val dropdownList = listOf("musoc", "catedral")

        binding.atvCategory.setDropdown(dropdownList) {
            tos(dropdownList[it])
        }
    }

    fun showDialog() = AddDivisionFragment().show(supportFragmentManager, AddDivisionFragment::class.java.simpleName)

}