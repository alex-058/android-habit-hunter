package org.othr.habithunter.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import org.othr.habithunter.firebase.FirebaseDBManager
import org.othr.habithunter.models.HabitModel
import timber.log.Timber
import java.lang.Exception

class DashboardViewModel : ViewModel() {

    private val habitList =
        MutableLiveData<List<HabitModel>>()

    val observableHabitList: LiveData<List<HabitModel>>
        get() = habitList

    var liveFirebaseUser = MutableLiveData<FirebaseUser>()

    init { load() }

    fun load() {
        try {
            //DonationManager.findAll(liveFirebaseUser.value?.email!!, donationsList)
            FirebaseDBManager.findAllByUser(liveFirebaseUser.value?.uid!!,
                habitList) // get data from firebase
            Timber.i("Report Load Success : ${habitList.value.toString()}")
        }
        catch (e: Exception) {
            Timber.i("Report Load Error : $e.message")
        }

    }

    fun delete(userid: String, id: String) {
        // HabitManager.delete(id)
        try {
            //DonationManager.delete(userid,id)
            FirebaseDBManager.delete(userid,id)
            Timber.i("Dashboard Delete Success")
        }
        catch (e: Exception) {
            Timber.i("Dashboard Delete Error : $e.message")
        }
    }
}