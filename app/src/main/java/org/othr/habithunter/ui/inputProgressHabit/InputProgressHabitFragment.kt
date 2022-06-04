package org.othr.habithunter.ui.inputProgressHabit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import org.othr.habithunter.R
import org.othr.habithunter.databinding.FragmentInputProgressHabitBinding

class InputProgressHabitFragment : Fragment() {

    private lateinit var inputProgressViewModel: InputProgressHabitViewModel
    private val args by navArgs<InputProgressHabitFragmentArgs>()
    private var _fragBinding: FragmentInputProgressHabitBinding? = null
    private val fragBinding get() = _fragBinding!!
    var habitProgress = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inputProgressViewModel = ViewModelProvider(this).get(InputProgressHabitViewModel::class.java)
        _fragBinding = FragmentInputProgressHabitBinding.inflate(inflater, container, false)

        inputProgressViewModel.observableHabit.observe(viewLifecycleOwner, Observer { render() })

        // Retrieve habit data in the beginning
        inputProgressViewModel.getHabit(args.habitId)

        habitProgress = inputProgressViewModel.getProgress()

        // Set max progress bar to be in sync
        fragBinding.progressBar.max = inputProgressViewModel.getGoalAmount()

        fragBinding.buttonIncrease.setOnClickListener {
            if (habitProgress>= fragBinding.progressBar.max) {
                Toast.makeText(context,"You have already reached the goal!", Toast.LENGTH_LONG).show()
            }
            else {
                habitProgress++;
                fragBinding.progressBar.progress = habitProgress
                inputProgressViewModel.increaseProgress(1) // TODO: Needed?
                fragBinding.textViewProgress.text = inputProgressViewModel.getProgress().toString()

                if (habitProgress >= fragBinding.progressBar.max) {
                    Toast.makeText(context,"Goal reached!!", Toast.LENGTH_LONG).show()
                }
            }
        }

        fragBinding.buttonDecrease.setOnClickListener {
            if (habitProgress <= 0) {
                Toast.makeText(context,"Attention. Negative progress not permitted!", Toast.LENGTH_LONG).show()
            }
            else {
                habitProgress--;
                fragBinding.progressBar.progress = habitProgress
                inputProgressViewModel.decreaseProgress(1) // TODO: Needed?
                fragBinding.textViewProgress.text = inputProgressViewModel.getProgress().toString()
                // TODO: Are these calls on the view model really needed?
                // TODO: Two-way-data binding maybe the solution -> layout should retrieve it from the view model automatically ?
            }
        }

        fragBinding.buttonIncreaseBy5.setOnClickListener {
            if (habitProgress>= fragBinding.progressBar.max) {
                Toast.makeText(context,"You have already reached the goal!", Toast.LENGTH_LONG).show()
            }
            else {
                habitProgress = habitProgress + 5;
                fragBinding.progressBar.progress = habitProgress
                inputProgressViewModel.increaseProgress(5) // TODO: Needed?
                fragBinding.textViewProgress.text = inputProgressViewModel.getProgress().toString()

                if (habitProgress >= fragBinding.progressBar.max) {
                    Toast.makeText(context,"Goal reached!!", Toast.LENGTH_LONG).show()
                }
            }
        }

        return fragBinding.root
    }

    private fun render() {
        fragBinding.habitvm = inputProgressViewModel
    }

    override fun onResume() {
        super.onResume()
        inputProgressViewModel.getHabit(args.habitId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragBinding = null
    }
}