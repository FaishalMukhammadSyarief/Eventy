package com.zhalz.eventy.utils.extension

import android.animation.ObjectAnimator
import android.content.Context
import android.view.View
import android.view.View.ALPHA
import android.view.View.TRANSLATION_Y
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.zhalz.eventy.R
import com.zhalz.eventy.presentation.adapter.PagerAdapter

/*  Visibility  */
fun View.gone() = this.apply {
    visibility = View.GONE
}

fun View.visible() = this.apply {
    visibility = View.VISIBLE
}


/*  UI Component  */
fun RecyclerView.addDivider(context: Context, orientation: Int = LinearLayoutManager.VERTICAL) =
    DividerItemDecoration(context, orientation).also {
        addItemDecoration(it)
    }

fun AutoCompleteTextView.setDropdown(list: List<String?>, onSelected: (Int) -> Unit) {
    ArrayAdapter<String>(this.context, R.layout.dm_coordinator, list).also {
        setAdapter(it)
    }

    setOnItemClickListener { _, _, position, _ ->
        onSelected(position)
    }
}

fun ViewPager2.setupWithTabLayout(
    activity: FragmentActivity,
    tabLayout: TabLayout,
    fragments: List<Fragment>,
    titles: List<String>
) {
    adapter = PagerAdapter(activity, fragments)

    TabLayoutMediator(tabLayout, this) { tab, position ->
        tab.text = titles[position]
    }.attach()
}


/*  Animations  */
fun View.slideDown() = ObjectAnimator.ofFloat(this, TRANSLATION_Y, 0f, this.height.toFloat())
    .setDuration(400)
    .start()

fun View.slideUp() = ObjectAnimator.ofFloat(this, TRANSLATION_Y, this.height.toFloat(), 0f)
    .setDuration(400)
    .start()

fun View.fadeIn() = ObjectAnimator.ofFloat(this, ALPHA, 0f, 1f)
    .setDuration(400)
    .start()

fun View.fadeOut() = ObjectAnimator.ofFloat(this, ALPHA, 1f, 0f)
    .setDuration(400)
    .start()