package org.othr.habithunter.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.othr.habithunter.models.HabitManager
import org.othr.habithunter.models.HabitModel
import java.lang.Exception

class DashboardViewModel : ViewModel() {

    private val habitList =
        MutableLiveData<List<HabitModel>>()

    val observableHabitList: LiveData<List<HabitModel>>
        get() = habitList

    init { load() }

    fun load() {
        habitList.value = HabitManager.getHabits() // get data from storage
    }
}