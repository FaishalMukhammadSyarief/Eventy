package com.zhalz.eventy.presentation.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zhalz.eventy.presentation.collaborator.CollaboratorFragment
import com.zhalz.eventy.presentation.friend.FriendFragment

class DivisionPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int) =
        when(position) {
            0 -> FriendFragment()
            1 -> CollaboratorFragment()
            else -> CollaboratorFragment()
        }

}