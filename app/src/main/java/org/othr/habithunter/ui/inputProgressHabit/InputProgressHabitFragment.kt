package org.othr.habithunter.ui.inputProgressHabit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import me.tankery.lib.circularseekbar.CircularSeekBar
import org.othr.habithunter.R
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

        // Deal initially with seek Bar
        binding.progressBar.progress = inputProgressViewModel.getProgress().toFloat()
        binding.progressBar.max = inputProgressViewModel.getGoal().toFloat()

        binding.progressBar.setOnSeekBarChangeListener(object : CircularSeekBar.OnCircularSeekBarChangeListener{

            override fun onProgressChanged(
                circularSeekBar: CircularSeekBar?,
                progress: Float,
                fromUser: Boolean
            ) {
                // here, you react to the value being set in seekBar
                binding.textViewProgress.setText(progress.toInt().toString())

            }

            override fun onStartTrackingTouch(seekBar: CircularSeekBar?) {
                Toast.makeText(context, "Start Gaining", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: CircularSeekBar?) {
                inputProgressViewModel.setProgress(seekBar!!.progress.toInt())
            }
        })


        binding.buttonProgressDone.setOnClickListener {
            binding.progressBar.progress = binding.progressBar.max
            inputProgressViewModel.boostProgress()
            Toast.makeText(context,"Goal reached!!", Toast.LENGTH_LONG).show()
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
