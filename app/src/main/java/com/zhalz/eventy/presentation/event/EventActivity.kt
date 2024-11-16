package com.zhalz.eventy.presentation.event

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityEventBinding
import com.zhalz.eventy.databinding.ItemDivisionBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.domain.model.Event
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_EVENT

class EventActivity : BaseActivity<ActivityEventBinding, EventViewModel>(R.layout.activity_event) {

    private val divisionAdapter by lazy {
        ReactiveListAdapter<ItemDivisionBinding, Division>(R.layout.item_division)
    }

    private val event: Event? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) intent.getParcelableExtra(EXTRA_EVENT, Event::class.java)
        else @Suppress("DEPRECATION") intent.getParcelableExtra(EXTRA_EVENT)
    }

    var title = ""
    var date = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        title = event?.title.orEmpty()
        date = event?.date.orEmpty()

        binding.activity = this
        binding.divisionAdapter = divisionAdapter

        val divisionList = event?.divisionList

        divisionAdapter.submitList(divisionList)

    }

}