package org.othr.habithunter.ui.inputProgressHabit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import org.othr.habithunter.R
import org.othr.habithunter.databinding.FragmentAddCustomHabitBinding
import org.othr.habithunter.databinding.FragmentInputProgressHabitBinding

class InputProgressHabitFragment : Fragment() {

    private lateinit var inputProgressViewModel: InputProgressHabitViewModel
    private val args by navArgs<InputProgressHabitFragmentArgs>()
    private var _binding: FragmentInputProgressHabitBinding? = null
    private val binding get() = _binding!!
    var habitProgress = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_input_progress_habit, container, false)
        inputProgressViewModel = ViewModelProvider(this).get(InputProgressHabitViewModel::class.java)

        binding.habitvm = inputProgressViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        // Observe callback method not needed for the moment
        // inputProgressViewModel.observableHabit.observe(viewLifecycleOwner, Observer { render() })

        // Retrieve habit data in the beginning from args parameter passed
        inputProgressViewModel.getHabit(args.habitId)

        // Retrieve progress
        habitProgress = inputProgressViewModel.getProgress()


        // Button listener
        binding.buttonIncrease.setOnClickListener {
            if (habitProgress>= binding.progressBar.max) {
                Toast.makeText(context,"You have already reached the goal!", Toast.LENGTH_LONG).show()
            }
            else {
                habitProgress++;
                inputProgressViewModel.increaseProgress(1) // updates layout

                if (habitProgress >= binding.progressBar.max) {
                    Toast.makeText(context,"Goal reached!!", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.buttonDecrease.setOnClickListener {
            if (habitProgress <= 0) {
                Toast.makeText(context,"Attention. Negative progress not permitted!", Toast.LENGTH_LONG).show()
            }
            else {
                habitProgress--;
                inputProgressViewModel.decreaseProgress(1)
            }
        }

        binding.buttonIncreaseBy5.setOnClickListener {
            if (habitProgress>= binding.progressBar.max) {
                Toast.makeText(context,"You have already reached the goal!", Toast.LENGTH_LONG).show()
            }
            else {
                habitProgress = habitProgress + 5;
                inputProgressViewModel.increaseProgress(5)

                if (habitProgress >= binding.progressBar.max) {
                    Toast.makeText(context,"Goal reached!!", Toast.LENGTH_LONG).show()
                }
            }
        }


        return binding.root
    }

    /*
    private fun render() {
        fragBinding.habitvm = inputProgressViewModel
        Toast.makeText(context, "Render function triggered", Toast.LENGTH_SHORT).show()
    }

     */

    override fun onResume() {
        super.onResume()
        inputProgressViewModel.getHabit(args.habitId)
    }

    override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

}