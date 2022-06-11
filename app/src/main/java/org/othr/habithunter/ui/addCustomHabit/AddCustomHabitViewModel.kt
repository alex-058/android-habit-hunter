package org.othr.habithunter.ui.addCustomHabit

import androidx.databinding.Bindable
import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.othr.habithunter.R
import org.othr.habithunter.models.HabitIntervall
import org.othr.habithunter.models.HabitManager
import org.othr.habithunter.models.HabitModel

class AddCustomHabitViewModel : ViewModel() {

    /* Does not work with two-way data binding (Compiling error)
    private val _radioChecked = MutableLiveData(R.id.radioButtonMonthly) // default value

    val observableRadioChecked: LiveData<Int>
        get() = _radioChecked
     */

    var observableRadioChecked = MutableLiveData(R.id.radioButtonDaily)

    private val _habit = MutableLiveData<HabitModel>()

    val observableHabit: LiveData<HabitModel>
        get() =  _habit

    fun getHabit(id: String) {
        _habit.value = HabitManager.getHabitById(id)
    }

    fun addHabit(habit: HabitModel) {

        when(observableRadioChecked.value) {
            R.id.radioButtonDaily -> habit.habitIntervall = HabitIntervall.DAILY // here is the operation on the model
            R.id.radioButtonWeekly -> habit.habitIntervall = HabitIntervall.WEEKLY
            R.id.radioButtonMonthly -> habit.habitIntervall = HabitIntervall.MONTHLY
        }

        HabitManager.create(habit)
    }

    fun updateHabit (id: String, habit: HabitModel) {
        HabitManager.update(id, habit)
        _habit.value = observableHabit.value
    }




}