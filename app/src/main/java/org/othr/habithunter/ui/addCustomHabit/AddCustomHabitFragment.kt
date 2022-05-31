package org.othr.habithunter.ui.addCustomHabit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.othr.habithunter.R

class AddCustomHabitFragment : Fragment() {

    companion object {
        fun newInstance() = AddCustomHabitFragment()
    }

    private lateinit var viewModel: AddCustomHabitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_custom_habit, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddCustomHabitViewModel::class.java)
        // TODO: Use the ViewModel
    }

}