package org.othr.habithunter.ui.inputProgressHabit

import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.othr.habithunter.models.FirebaseDBManager
import org.othr.habithunter.models.HabitManager
import org.othr.habithunter.models.HabitModel
import timber.log.Timber
import java.lang.Exception

class InputProgressHabitViewModel : ViewModel() {

    private val _habit = MutableLiveData<HabitModel>()

    var observableHabit: LiveData<HabitModel>
            get() =  _habit
            set(value) {_habit.value = value.value}

    init {
        _habit.value = HabitModel() // default initialize value of mutable live data
    }


    fun findHabitById(userid: String, habitId: String) {
        // _habit.value = FirebaseDBManager.findById(userid, habitId, _habit)
        // FirebaseDBManager.findById(userid, habitId, _habit)

        try {
            //DonationManager.findById(email, id, donation)
            FirebaseDBManager.findById(userid, habitId, _habit)
            val test = _habit.value
            Timber.i("Detail getHabitById() Success : ${
                _habit.value.toString()}")
        }
        catch (e: Exception) {
            Timber.i("Detail getHabitById() Error : $e.message")
        }
    }

    fun findHabitProgress () : Int {
        return _habit.value!!.habitProgress
    }

    fun createHabitProgress(n: Int) {
        _habit.value?.habitProgress = n
        // TODO: update of firebase entry needed
    }

    fun findhabitGoal () : Int {
        val test = _habit.value!!.habitGoal
        return _habit.value!!.habitGoal
    }

    fun boostHabitProgress() {
        _habit.value!!.habitProgress = _habit.value!!.habitGoal
        // TODO: update of firebase entry needed
    }


}