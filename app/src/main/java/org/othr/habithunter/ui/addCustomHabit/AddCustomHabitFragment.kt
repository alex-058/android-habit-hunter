package org.othr.habithunter.ui.addCustomHabit

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
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
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import org.othr.habithunter.R
import org.othr.habithunter.alarm.AlarmReceiver
import org.othr.habithunter.databinding.FragmentAddCustomHabitBinding
import org.othr.habithunter.models.HabitIntervall
import org.othr.habithunter.models.HabitManager
import org.othr.habithunter.models.HabitModel
import java.util.*


class AddCustomHabitFragment : Fragment() {

    // binding support
    private var _binding: FragmentAddCustomHabitBinding? = null
    private val binding get() = _binding!!
    private var editMode: Boolean = false

    private val args by navArgs<AddCustomHabitFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val addCustomHabitViewModel =
            ViewModelProvider(this).get(AddCustomHabitViewModel::class.java)

        _binding = FragmentAddCustomHabitBinding.inflate(inflater, container, false)
        val root = binding.root

        activity?.actionBar?.title = "Add custom habit"

        // Retrieve state  if args parameter passed
        editMode = (args.habitId?.isNullOrEmpty() == false)

        if (editMode) {
            addCustomHabitViewModel.getHabit(args.habitId!!)
        }


        // Binding ViewModel setup
        binding.viewmodel = addCustomHabitViewModel
        binding.lifecycleOwner = this

        addCustomHabitViewModel.observableRadioIntervallChecked.observe (viewLifecycleOwner, Observer {
            checked -> Toast.makeText(context, checked.toString(), Toast.LENGTH_SHORT).show()
        })

        addCustomHabitViewModel.observableRadioAmountChecked.observe(viewLifecycleOwner, Observer {
            checked -> when (checked) {
                R.id.radioButtonTime -> binding.numberPickerTime.isVisible = true
                R.id.radioButtonAmount -> binding.numberPickerTime.isVisible = false
        }
        })

        // Icon behaviour
        binding.profileImage.setOnClickListener {
            Toast.makeText(activity, "Please select an image", Toast.LENGTH_LONG)
                .show()
        }

        // Time Options Picker setup
        binding.numberPickerTime.displayedValues = resources.getStringArray(R.array.timeOptions)
        binding.numberPickerTime.maxValue = resources.getStringArray(R.array.timeOptions).size - 1

        // Button behaviour
        binding.addCustomHabitBttn.setOnClickListener {

            // Grab unit in every case
            val unit: String
            if (binding.radioButtonAmount.isChecked) {
                unit = "count"
            } else {
                val test = binding.numberPickerTime.value
                unit = binding.numberPickerTime.displayedValues.get(test)
            }


            if (editMode) {
                if ((binding.textHabitName.text?.isNotEmpty()!!) && (binding.numberPickerAmount.value > 0)) {
                    addCustomHabitViewModel.observableHabit.value!!.habitUnit = unit // to store also unit in the habit which is then stored
                    addCustomHabitViewModel.updateHabit(args.habitId!!, addCustomHabitViewModel.observableHabit.value!!)
                    findNavController().navigateUp() // go immediately back
                }

            }
            else {
                if ((binding.textHabitName.text?.isNotEmpty()!!) && (binding.numberPickerAmount.value > 0)) {
                    // operation on view model
                    addCustomHabitViewModel.addHabit(HabitModel(habitTitle = binding.textHabitName.text.toString(),
                        habitGoal = binding.numberPickerAmount.value, habitUnit = unit))
                    findNavController().navigateUp() // go immediately back

                } else {
                    Snackbar
                        .make(it, R.string.message_enterAllFields, Snackbar.LENGTH_LONG)
                        .show()
                }
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
        binding.numberPickerAmount.maxValue = 300000;

        // TODO: Does this align with MVVM principles?
        // Correctly present values when in edit-mode
        if (editMode) {
            when (addCustomHabitViewModel.observableHabit.value!!.habitIntervall) {
                HabitIntervall.DAILY -> addCustomHabitViewModel.observableRadioIntervallChecked.value = binding.radioButtonDaily.id
                HabitIntervall.WEEKLY -> addCustomHabitViewModel.observableRadioIntervallChecked.value = binding.radioButtonWeekly.id
                HabitIntervall.MONTHLY ->  addCustomHabitViewModel.observableRadioIntervallChecked.value = binding.radioButtonMonthly.id
            }

            // TODO: Goal is to take habit unit from observable habit and display it to the user
            when (addCustomHabitViewModel.observableHabit.value!!.habitUnit) {
                "amount" -> addCustomHabitViewModel.observableRadioAmountChecked.value = binding.radioButtonAmount.id

                "seconds" ->  {
                    addCustomHabitViewModel.observableRadioAmountChecked.value = binding.radioButtonTime.id
                    binding.numberPickerTime.value = resources.getStringArray(R.array.timeOptions).indexOf("seconds")
                }
                "minutes" ->  {
                    addCustomHabitViewModel.observableRadioAmountChecked.value = binding.radioButtonTime.id
                    binding.numberPickerTime.value = resources.getStringArray(R.array.timeOptions).indexOf("minutes")
                }
                "hours" ->  {
                    addCustomHabitViewModel.observableRadioAmountChecked.value = binding.radioButtonTime.id
                    binding.numberPickerTime.value = resources.getStringArray(R.array.timeOptions).indexOf("hours")
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