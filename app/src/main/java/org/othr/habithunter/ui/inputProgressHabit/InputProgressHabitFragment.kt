package org.othr.habithunter.ui.inputProgressHabit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import me.tankery.lib.circularseekbar.CircularSeekBar
import org.othr.habithunter.R
import org.othr.habithunter.databinding.FragmentInputProgressHabitBinding
import org.othr.habithunter.ui.profile.LoggedInViewModel

class InputProgressHabitFragment : Fragment() {

    private lateinit var inputProgressViewModel: InputProgressHabitViewModel
    private val args by navArgs<InputProgressHabitFragmentArgs>()
    private var _binding: FragmentInputProgressHabitBinding? = null
    private val binding get() = _binding!!

    private val loggedInViewModel : LoggedInViewModel by activityViewModels()

    var habitProgress = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_input_progress_habit, container, false)
        _binding = FragmentInputProgressHabitBinding.inflate(inflater, container, false)

        inputProgressViewModel = ViewModelProvider(this).get(InputProgressHabitViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.habitvm = inputProgressViewModel

        // Observe callback method not needed for the moment
        inputProgressViewModel.observableHabit.observe(viewLifecycleOwner, Observer { render() })

        // Retrieve habit data in the beginning from args parameter passed and logged-in user
        inputProgressViewModel.findHabitById(loggedInViewModel.liveFirebaseUser.value?.uid!!,args.habitId)

        // Retrieve progress
        habitProgress = inputProgressViewModel.findHabitProgress()

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
                inputProgressViewModel.createHabitProgress(seekBar!!.progress.toInt())
            }
        })


        binding.buttonProgressDone.setOnClickListener {
            binding.progressBar.progress = binding.progressBar.max
            inputProgressViewModel.boostHabitProgress()
            Toast.makeText(context,"Goal reached!!", Toast.LENGTH_LONG).show()
        }


        return binding.root
    }

    private fun render() {
        binding.habitvm = inputProgressViewModel
        binding.progressBar.progress = inputProgressViewModel.findHabitProgress().toFloat()
        binding.progressBar.max = inputProgressViewModel.findhabitGoal().toFloat()
        Toast.makeText(context, "Render function triggered", Toast.LENGTH_SHORT).show()
    }



    override fun onResume() {
        super.onResume()
        inputProgressViewModel.findHabitById(loggedInViewModel.liveFirebaseUser.value?.uid!!,args.habitId)
    }

    override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

}
