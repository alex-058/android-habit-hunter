package org.othr.habithunter.ui.addCustomHabit

import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import org.othr.habithunter.R
import org.othr.habithunter.databinding.FragmentAddCustomHabitBinding
import org.othr.habithunter.firebase.FirebaseDBManager
import org.othr.habithunter.firebase.FirebaseImageManager
import org.othr.habithunter.models.HabitIntervall
import org.othr.habithunter.models.HabitModel
import org.othr.habithunter.ui.profile.LoggedInViewModel
import org.othr.habithunter.utils.readImageUri
import org.othr.habithunter.utils.showImagePicker
import timber.log.Timber


class AddCustomHabitFragment : Fragment() {

    // binding support
    private var _binding: FragmentAddCustomHabitBinding? = null
    private val binding get() = _binding!!
    private var editMode: Boolean = false

    private val loggedInViewModel : LoggedInViewModel by activityViewModels()

    private val args by navArgs<AddCustomHabitFragmentArgs>()

    private lateinit var intentLauncher : ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val addCustomHabitViewModel =
            ViewModelProvider(this).get(AddCustomHabitViewModel::class.java)

        _binding = FragmentAddCustomHabitBinding.inflate(inflater, container, false)
        val root = binding.root

        activity?.actionBar?.title = "Add custom habit"

        registerImagePickerCallback()

        // Retrieve state  if args parameter passed
        editMode = (args.habitId?.isNullOrEmpty() == false)

        if (editMode) {
            addCustomHabitViewModel.findHabitById(loggedInViewModel.liveFirebaseUser.value?.uid!!,
                args.habitId!!)
            // TODO: Problem is async firebase call on findHabitById
            binding.textAddIcon.setText("Edit icon")
            binding.addCustomHabitBttn.setText("Update habit")
            // Display image in image view
            addCustomHabitViewModel.displayImage(loggedInViewModel.liveFirebaseUser.value?.uid!!,
            args.habitId!!, binding.profileImage)
        }


        // Binding ViewModel setup
        binding.viewmodel = addCustomHabitViewModel
        binding.lifecycleOwner = this

        addCustomHabitViewModel.observableRadioAmountChecked.observe(viewLifecycleOwner, Observer {
            checked -> when (checked) {
                R.id.radioButtonTime -> binding.numberPickerTime.isVisible = true
                R.id.radioButtonAmount -> binding.numberPickerTime.isVisible = false
        }
        })

        // Icon behaviour
        binding.profileImage.setOnClickListener {
            showImagePicker(intentLauncher)
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
                    addCustomHabitViewModel.updateHabit(loggedInViewModel.liveFirebaseUser.value?.uid!!,
                        args.habitId!!, addCustomHabitViewModel.observableHabit.value!!)
                    findNavController().navigateUp() // go immediately back
                }

            }
            else {
                if ((binding.textHabitName.text?.isNotEmpty()!!) && (binding.numberPickerAmount.value > 0)) {
                    // operation on view model
                    addCustomHabitViewModel.addHabit(firebaseUser = loggedInViewModel.liveFirebaseUser, HabitModel(habitTitle = binding.textHabitName.text.toString(),
                        habitGoal = binding.numberPickerAmount.value, habitUnit = unit, email = loggedInViewModel.liveFirebaseUser.value?.email!!))
                    findNavController().navigateUp() // go immediately back

                } else {
                    Snackbar
                        .make(it, R.string.message_enterAllFields, Snackbar.LENGTH_LONG)
                        .show()
                }
            }



        }

        // Amount Number Picker setup
        binding.numberPickerAmount.minValue
        binding.numberPickerAmount.maxValue = 300000;

        // Lessons Learned: Observe method gets triggered if async callback comes back
        addCustomHabitViewModel.observableHabit.observe(viewLifecycleOwner, Observer {
            // Correctly present values when in edit-mode
            if (editMode) {
                when (addCustomHabitViewModel.observableHabit.value!!.habitIntervall) {
                    HabitIntervall.DAILY -> addCustomHabitViewModel.observableRadioIntervallChecked.value = binding.radioButtonDaily.id
                    HabitIntervall.WEEKLY -> addCustomHabitViewModel.observableRadioIntervallChecked.value = binding.radioButtonWeekly.id
                    HabitIntervall.MONTHLY ->  addCustomHabitViewModel.observableRadioIntervallChecked.value = binding.radioButtonMonthly.id
                }

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
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun registerImagePickerCallback() {
        intentLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                when(result.resultCode){
                    RESULT_OK -> {
                        if (result.data != null) {
                            Timber.i("DX registerPickerCallback() ${readImageUri(result.resultCode, result.data).toString()}")
                            // TODO: Do something with image -> upload firebase, place in image view
                            FirebaseImageManager
                                .updateHabitImage(FirebaseDBManager.database.push().key!!, // generate new key for image
                                    readImageUri(result.resultCode, result.data),
                                    binding.profileImage,
                                    true)
                        } // end of if
                    }
                    RESULT_CANCELED -> { } else -> { }
                }
            }
    }


}