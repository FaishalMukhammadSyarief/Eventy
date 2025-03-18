package com.zhalz.eventy.utils.extension

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
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

fun View.invisible() = this.apply {
    visibility = View.INVISIBLE
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
fun View.slideDownGone(): ObjectAnimator = ObjectAnimator.ofFloat(this, TRANSLATION_Y, 0f, this.height.toFloat()).apply {
    duration = 400
    onFinish { gone() }
    start()
}

fun View.slideUpVisible(): ObjectAnimator = ObjectAnimator.ofFloat(this, TRANSLATION_Y, this.height.toFloat(), 0f).apply {
    duration = 400
    onStart { visible() }
    start()
}

fun View.fadeOut(): ObjectAnimator = ObjectAnimator.ofFloat(this, ALPHA, 1f, 0f).apply {
    duration = 300
    onFinish { gone() }
    start()
}

fun View.fadeIn(): ObjectAnimator = ObjectAnimator.ofFloat(this, ALPHA, 0f, 1f).apply {
    duration = 300
    onStart { visible() }
    start()
}

fun ObjectAnimator.onFinish(onFinish: () -> Unit) = this.addListener(
    object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator) {
            super.onAnimationEnd(animation)
            onFinish()
        }
    })

fun ObjectAnimator.onStart(onStart: () -> Unit) = this.addListener(
    object : AnimatorListenerAdapter() {
        override fun onAnimationStart(animation: Animator) {
            super.onAnimationStart(animation)
            println("test start 1")
            onStart()
        }
    })