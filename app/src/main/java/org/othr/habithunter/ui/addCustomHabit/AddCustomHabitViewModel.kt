package org.othr.habithunter.ui.addCustomHabit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import org.othr.habithunter.R
import org.othr.habithunter.firebase.FirebaseDBManager
import org.othr.habithunter.models.HabitIntervall
import org.othr.habithunter.models.HabitModel
import timber.log.Timber
import java.lang.Exception

class AddCustomHabitViewModel : ViewModel() {


    var observableRadioIntervallChecked = MutableLiveData(R.id.radioButtonDaily)

    var observableRadioAmountChecked = MutableLiveData(R.id.radioButtonAmount)

    private val _habit = MutableLiveData<HabitModel>()

    val observableHabit: LiveData<HabitModel>
        get() =  _habit

    init {
        _habit.value = HabitModel() // default initialize value of mutable live data
    }


    fun findHabitById(userid: String, habitId: String) {
        try {
            //DonationManager.findById(email, id, donation)
            FirebaseDBManager.findById(userid, habitId, _habit)
            Timber.i("Detail getHabitById() Success : ${
                _habit.value.toString()}")
        }
        catch (e: Exception) {
            Timber.i("Detail getHabitById() Error : $e.message")
        }
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

    fun updateHabit (uid: String, id: String, habit: HabitModel) {

        when(observableRadioIntervallChecked.value) {
            R.id.radioButtonDaily -> habit.habitIntervall = HabitIntervall.DAILY // here is the operation on the model
            R.id.radioButtonWeekly -> habit.habitIntervall = HabitIntervall.WEEKLY
            R.id.radioButtonMonthly -> habit.habitIntervall = HabitIntervall.MONTHLY
        }

        // HabitManager.update(id, habit)
        FirebaseDBManager.update(uid, id, habit)
    }




}