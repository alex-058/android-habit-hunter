package org.othr.habithunter.ui.addCustomHabit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.othr.habithunter.R
import org.othr.habithunter.databinding.FragmentAddCustomHabitBinding
import org.othr.habithunter.models.HabitModel
import org.othr.habithunter.ui.dashboard.DashboardViewModel

class AddCustomHabitFragment : Fragment() {

    // binding support
    private var _binding: FragmentAddCustomHabitBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val addCustomHabitViewModel =
            ViewModelProvider(this).get(AddCustomHabitViewModel::class.java)

        addCustomHabitViewModel.observableStatus.observe(viewLifecycleOwner, Observer {
                status -> status?.let { render(status) }
        })

        _binding = FragmentAddCustomHabitBinding.inflate(inflater, container, false)
        val root = binding.root

        activity?.actionBar?.title = "Add custom habit"

        // Icon behaviour
        binding.profileImage.setOnClickListener {
            Toast.makeText(activity, "Please select an image", Toast.LENGTH_LONG)
                .show()
        }

        // Button behaviour
        binding.addCustomHabitBttn.setOnClickListener {
            Toast.makeText(activity, "You pressed the Add habit button", Toast.LENGTH_LONG)
                .show()
            // operation on view model
            addCustomHabitViewModel.addHabit(HabitModel(habitTitle = binding.textHabitName.toString()))
            findNavController().navigateUp() // go immediately back
        }

        // Dealing with keyboard focus -> does not work yet
        /*binding.textHabitName.setOnFocusChangeListener(OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                hideSoftKeyboard(v)
            }
        }) */

        // Amount Number Picker setup
        binding.numberPickerAmount.minValue
        binding.numberPickerAmount.maxValue = 60;


        binding.numberPickerAmount.setOnValueChangedListener(NumberPicker.OnValueChangeListener { picker, oldVal, newVal ->

        })

        // Time Options Picker setup
        binding.numberPickerTime.displayedValues= resources.getStringArray(R.array.timeOptions)
        binding.numberPickerTime.maxValue = resources.getStringArray(R.array.timeOptions).size - 1

        binding.amountTimeRadioGroup.setOnCheckedChangeListener { radioGroup, optionId ->
            run {
                when (optionId) {
                    R.id.radioButtonTime -> {
                        // do something when radio button 1 is selected
                        binding.numberPickerTime.isVisible = true
                    }
                    R.id.radioButtonAmount -> {
                        binding.numberPickerTime.isVisible = false
                    }
                }
            }
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
    }

    private fun render(status: Boolean) {
        when (status) {
            true -> {
                view?.let {
                    //Uncomment this if you want to immediately return to Report
                    //findNavController().popBackStack()
                }
            }
            false -> Toast.makeText(context,getString(R.string.habitErrorMessage),Toast.LENGTH_LONG).show()
        }
    }

}