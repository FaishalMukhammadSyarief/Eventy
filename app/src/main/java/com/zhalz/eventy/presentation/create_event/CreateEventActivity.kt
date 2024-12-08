package com.zhalz.eventy.presentation.create_event

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import com.google.android.material.datepicker.MaterialDatePicker.todayInUtcMilliseconds
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityCreateEventBinding
import com.zhalz.eventy.databinding.ItemDivisionBinding
import com.zhalz.eventy.databinding.ItemScheduleBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.domain.model.Schedule
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CreateEventActivity : BaseActivity<ActivityCreateEventBinding, CreateEventViewModel>(R.layout.activity_create_event) {

    private val divisionAdapter by lazy {
        ReactiveListAdapter<ItemDivisionBinding, Division>(R.layout.item_division)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

        binding.divisionAdapter = divisionAdapter

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

    private fun showMaterialDatePicker(onDateSelected: (String) -> Unit) {
        val datePicker = datePicker()
            .setTitleText("Select Start Date")
            .setSelection(todayInUtcMilliseconds())
            .build()

        datePicker.addOnPositiveButtonClickListener { selection ->
            val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                .format(Date(selection))
            onDateSelected(formatter)
        }

        datePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER")
    }

}