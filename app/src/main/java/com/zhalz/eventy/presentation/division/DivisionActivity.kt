package com.zhalz.eventy.presentation.division

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.TIRAMISU
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.crocodic.core.extension.openActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityDivisionBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.presentation.dialog.add_person.AddPersonFragment
import com.zhalz.eventy.presentation.division.task.TaskFragment
import com.zhalz.eventy.presentation.member.MemberActivity
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_DIVISION
import com.zhalz.eventy.utils.extension.setupWithTabLayout

class DivisionActivity : BaseActivity<ActivityDivisionBinding, DivisionViewModel>(R.layout.activity_division) {

    val division: Division? by lazy {
        if (SDK_INT >= TIRAMISU) intent.getParcelableExtra(EXTRA_DIVISION, Division::class.java)
        else @Suppress("DEPRECATION") intent.getParcelableExtra(EXTRA_DIVISION)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this
        binding.division = division

        initUI()
    }

    private fun initUI() {
        binding.viewPager.setupWithTabLayout(
            this,
            binding.tabLayout,
            listOf(TaskFragment(), TaskFragment(), TaskFragment()),
            listOf("TASK", "IN PROGRESS", "COMPLETED")
        )

        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_add_collaborator -> AddPersonFragment().show(supportFragmentManager, AddPersonFragment::class.java.simpleName)
                R.id.menu_member -> openActivity<MemberActivity>()
            }
            true
        }
    }

}