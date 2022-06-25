package org.othr.habithunter.ui.addCustomHabit

import androidx.databinding.Bindable
import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import org.othr.habithunter.R
import org.othr.habithunter.models.FirebaseDBManager
import org.othr.habithunter.models.HabitIntervall
import org.othr.habithunter.models.HabitManager
import org.othr.habithunter.models.HabitModel

class AddCustomHabitViewModel : ViewModel() {

    /* Does not work with two-way data binding (Compiling error)
    private val _radioChecked = MutableLiveData(R.id.radioButtonMonthly) // default value

    val observableRadioChecked: LiveData<Int>
        get() = _radioChecked
     */

    var observableRadioIntervallChecked = MutableLiveData(R.id.radioButtonDaily)

    var observableRadioAmountChecked = MutableLiveData(R.id.radioButtonAmount)

    private val _habit = MutableLiveData<HabitModel>()

    val observableHabit: LiveData<HabitModel>
        get() =  _habit

    fun getHabit(id: String) {
        _habit.value = HabitManager.getHabitById(id)
    }

    fun addHabit(firebaseUser: MutableLiveData<FirebaseUser>, habit: HabitModel) {

        when(observableRadioIntervallChecked.value) {
            R.id.radioButtonDaily -> habit.habitIntervall = HabitIntervall.DAILY // here is the operation on the model
            R.id.radioButtonWeekly -> habit.habitIntervall = HabitIntervall.WEEKLY
            R.id.radioButtonMonthly -> habit.habitIntervall = HabitIntervall.MONTHLY
        }

        // HabitManager.create(habit)
        FirebaseDBManager.create(firebaseUser, habit)
        // _habit.value = observableHabit.value
    }

    fun updateHabit (id: String, habit: HabitModel) {

        when(observableRadioIntervallChecked.value) {
            R.id.radioButtonDaily -> habit.habitIntervall = HabitIntervall.DAILY // here is the operation on the model
            R.id.radioButtonWeekly -> habit.habitIntervall = HabitIntervall.WEEKLY
            R.id.radioButtonMonthly -> habit.habitIntervall = HabitIntervall.MONTHLY
        }

        HabitManager.update(id, habit)
        _habit.value = observableHabit.value
    }




}