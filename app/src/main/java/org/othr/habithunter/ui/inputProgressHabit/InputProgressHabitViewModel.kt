package org.othr.habithunter.ui.inputProgressHabit

import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.othr.habithunter.models.HabitManager
import org.othr.habithunter.models.HabitModel

class InputProgressHabitViewModel : ViewModel() {

    private val _habit = MutableLiveData<HabitModel>()

    val observableHabit: LiveData<HabitModel>
            get() =  _habit

    fun getHabit(id: String) {
        _habit.value = HabitManager.getHabitById(id)
    }

    fun getProgress () : Int {
        return _habit.value!!.habitProgress
    }

    fun setProgress(n: Int) {
        _habit.value?.habitProgress = n
        _habit.value = observableHabit.value
    }

    fun getGoal () : Int {
        return _habit.value!!.habitGoal
    }

    fun boostProgress() {
        _habit.value!!.habitProgress = _habit.value!!.habitGoal
        _habit.value = observableHabit.value
    }


}