package com.zhalz.eventy.utils.extension

import android.animation.ObjectAnimator
import android.content.Context
import android.view.View
import android.view.View.ALPHA
import android.view.View.TRANSLATION_Y
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zhalz.eventy.R

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