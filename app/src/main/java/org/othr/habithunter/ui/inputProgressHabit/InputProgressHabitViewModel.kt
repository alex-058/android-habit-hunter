package org.othr.habithunter.ui.inputProgressHabit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.othr.habithunter.models.HabitManager
import org.othr.habithunter.models.HabitModel

class InputProgressHabitViewModel : ViewModel() {

    private val habit = MutableLiveData<HabitModel>()

    val observableHabit: LiveData<HabitModel>
            get() = habit

    fun getHabit(id: String) {
        habit.value = HabitManager.getHabitById(id)
    }

    fun increaseProgress(n: Int) {
        habit.value?.habitProgress = habit.value?.habitProgress!! + n
    }

    // TODO: Could also be done directly in the layout, I believe -> listener on this field
    fun decreaseProgress(n: Int) {
        habit.value?.habitProgress = habit.value?.habitProgress!! - n
    }

    // TODO: Retrieving viewModel "attributes" should not be needed with two-way data binding
    fun getGoalAmount () : Int {
        return habit.value!!.habitGoal
    }

    fun getProgress () : Int {
        return habit.value!!.habitProgress
    }

}