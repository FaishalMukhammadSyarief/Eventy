package com.zhalz.eventy.presentation.division

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.tabs.TabLayout
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentDivisionBinding
import com.zhalz.eventy.presentation.division.task.TaskFragment
import com.zhalz.eventy.utils.extension.setupTabPager

class DivisionFragment : BaseFragment<FragmentDivisionBinding>(R.layout.fragment_division) {

    private val args by navArgs<DivisionFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind.division = args.division

        initUI()

    }

    private fun initUI() {
        bind.collapsingToolbar.setupWithNavController(bind.toolbar, findNavController())
        bind.toolbar.title = args.division.title

        setTabLayout()
    }

    private fun setTabLayout() {
        val fragments = listOf(TaskFragment(), TaskFragment(), TaskFragment())
        val tabTitles = listOf("Uncompleted ", "In-Progress", "Completed")
        val tabIcons = listOf(
            getDrawable(requireContext(), R.drawable.ic_cross_circle),
            getDrawable(requireContext(), R.drawable.ic_play_circle),
            getDrawable(requireContext(), R.drawable.ic_check_circle),
        )

        bind.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.text = tabTitles[tab.position]
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.text = null
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        setupTabPager(
            bind.viewPager,
            bind.tabLayout,
            fragments,
            null,
            tabIcons
        )
    }

}