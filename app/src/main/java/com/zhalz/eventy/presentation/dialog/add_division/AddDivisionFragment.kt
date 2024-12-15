package com.zhalz.eventy.presentation.dialog.add_division

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.crocodic.core.extension.tos
import com.zhalz.eventy.R
import com.zhalz.eventy.data.teamList
import com.zhalz.eventy.databinding.FragmentAddDivisionBinding
import com.zhalz.eventy.domain.model.Person
import com.zhalz.eventy.utils.setDropdown

class AddDivisionFragment : DialogFragment() {

    private var _binding: FragmentAddDivisionBinding? = null
    private val binding get() = _binding!!

    var title = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_division, container, false)

        binding.dialog = this

        setCoordinator(teamList)

        return binding.root
    }

    private fun setCoordinator(listCoordinator: List<Person>) {
        val dropdownList = listCoordinator.map { it.name }

        binding.atvCoordinator.setDropdown(dropdownList) {
            context?.tos(listCoordinator[it].name)
        }
    }

/*    private fun createDivision(id: Int, title: String, color: Int, team: List<Person>, task: List<Task>) {
        divisionList.add(
            Division(id, title, color, team, task)
        )
    }*/

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            val marginHorizontal = resources.getDimensionPixelSize(R.dimen.margin_dialog)
            val screenWidth = resources.displayMetrics.widthPixels

            setLayout(screenWidth - 2 * marginHorizontal, WRAP_CONTENT)

            setBackgroundDrawableResource(R.drawable.bg_slightly_round)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}