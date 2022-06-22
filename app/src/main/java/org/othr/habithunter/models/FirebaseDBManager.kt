package org.othr.habithunter.models

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import timber.log.Timber

object FirebaseDBManager : IHabitCrudFirebaseDB {

    var database: DatabaseReference = FirebaseDatabase.getInstance("https://oth-habithunter-default-rtdb.europe-west1.firebasedatabase.app").reference

    override fun findAll(habitList: MutableLiveData<List<HabitModel>>) {
        TODO("Not yet implemented")
    }

    override fun findAll(userid: String, habitList: MutableLiveData<List<HabitModel>>) {
        TODO("Not yet implemented")
    }

    override fun findById(userid: String, habitId: String, habit: MutableLiveData<HabitModel>) {
        TODO("Not yet implemented")
    }

    override fun create(firebaseUser: MutableLiveData<FirebaseUser>, habit: HabitModel) {
        val uid = firebaseUser.value!!.uid
        val key = database.child("habits").push().key
        if (key == null) {
            Timber.i("Error with Firebase : Key empty")
            return
        }

        habit.uid = key
        val habitValues = habit.toMap()

        val childAdd = HashMap<String, Any>()
        childAdd["/habits/$key"] = habitValues
        childAdd["/user-habits/$uid/$key"] = habitValues

        database.updateChildren(childAdd)
    }

    override fun delete(userid: String, habitId: String) {
        TODO("Not yet implemented")
    }

    override fun update(userid: String, habitId: String, habit: HabitModel) {
        TODO("Not yet implemented")
    }
}