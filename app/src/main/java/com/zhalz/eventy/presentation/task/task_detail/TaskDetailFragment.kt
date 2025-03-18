package com.zhalz.eventy.presentation.task.task_detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.commentList
import com.zhalz.eventy.databinding.FragmentTaskDetailBinding
import com.zhalz.eventy.databinding.ItemCommentBinding
import com.zhalz.eventy.domain.model.Comment

class TaskDetailFragment : BaseFragment<FragmentTaskDetailBinding>(R.layout.fragment_task_detail) {

    private val args by navArgs<TaskDetailFragmentArgs>()

    private val activity by lazy { requireActivity() as AppCompatActivity }

    private val commentAdapter by lazy {
        ReactiveListAdapter<ItemCommentBinding, Comment>(R.layout.item_comment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let{
            it.collapsingToolbar.setupWithNavController(it.toolbar, findNavController())
            it.task = args.task
            it.adapter = commentAdapter
        }

        initUI()

    }

    private fun initUI() {
        activity.supportActionBar?.title = args.task.title

        commentAdapter.submitList(commentList)
    }

}