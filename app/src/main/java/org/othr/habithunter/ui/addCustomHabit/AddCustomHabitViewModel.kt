package org.othr.habithunter.ui.addCustomHabit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.othr.habithunter.models.HabitManager
import org.othr.habithunter.models.HabitModel

class AddCustomHabitViewModel : ViewModel() {

    private val status = MutableLiveData<Boolean>()

    val observableStatus: LiveData<Boolean>
        get() = status

    fun addHabit(habit: HabitModel) {
        status.value = try {
            HabitManager.create(habit)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }
}