package com.zhalz.eventy.presentation.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zhalz.eventy.presentation.collaborator.CollaboratorFragment
import com.zhalz.eventy.presentation.friend.FriendFragment

class PagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int) =
        when(position) {
            0 -> FriendFragment()
            else -> CollaboratorFragment()
    }

}