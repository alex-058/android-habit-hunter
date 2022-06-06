package org.othr.habithunter.ui.addCustomHabit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import org.othr.habithunter.R
import org.othr.habithunter.databinding.FragmentAddCustomHabitBinding
import org.othr.habithunter.models.HabitModel


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

        _binding = FragmentAddCustomHabitBinding.inflate(inflater, container, false)
        val root = binding.root

        activity?.actionBar?.title = "Add custom habit"

        // Binding ViewModel setup
        binding.viewmodel = addCustomHabitViewModel
        binding.lifecycleOwner = this

        addCustomHabitViewModel.observableRadioChecked.observe (viewLifecycleOwner, Observer {
            checked -> Toast.makeText(context, checked.toString(), Toast.LENGTH_SHORT).show()
        })

        // Icon behaviour
        binding.profileImage.setOnClickListener {
            Toast.makeText(activity, "Please select an image", Toast.LENGTH_LONG)
                .show()
        }

        // Button behaviour
        binding.addCustomHabitBttn.setOnClickListener {

            if ((binding.textHabitName.text?.isNotEmpty()!!) && (binding.numberPickerAmount.value > 0)) {
                // operation on view model
                addCustomHabitViewModel.addHabit(HabitModel(habitTitle = binding.textHabitName.text.toString(),
                habitGoal = binding.numberPickerAmount.value))
                findNavController().navigateUp() // go immediately back

            } else {
                Snackbar
                    .make(it, R.string.message_enterAllFields, Snackbar.LENGTH_LONG)
                    .show()
            }


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
        binding.numberPickerTime.displayedValues = resources.getStringArray(R.array.timeOptions)
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


}