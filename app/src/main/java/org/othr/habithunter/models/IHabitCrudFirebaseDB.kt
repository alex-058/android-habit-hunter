package org.othr.habithunter.models

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser

interface IHabitCrudFirebaseDB {

    fun findAll(habitList:
                MutableLiveData<List<HabitModel>>)
    fun findAll(userid:String,
                habitList:
                MutableLiveData<List<HabitModel>>)
    fun findById(userid:String, habitId: String,
                 habit: MutableLiveData<HabitModel>)
    fun create(firebaseUser: MutableLiveData<FirebaseUser>, habit: HabitModel)
    fun delete(userid:String, habitId: String)
    fun update(userid:String, habitId: String, habit: HabitModel)

}