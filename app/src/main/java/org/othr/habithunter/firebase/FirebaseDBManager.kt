package org.othr.habithunter.firebase

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import org.othr.habithunter.models.HabitModel
import org.othr.habithunter.models.IHabitCrudFirebaseDB
import timber.log.Timber

object FirebaseDBManager : IHabitCrudFirebaseDB {

    // Updated google-service.json should not need the link in the end
    // var database: DatabaseReference = FirebaseDatabase.getInstance("https://oth-habithunter-default-rtdb.europe-west1.firebasedatabase.app").reference

    var database: DatabaseReference = FirebaseDatabase.getInstance("https://oth-habithunter-default-rtdb.europe-west1.firebasedatabase.app").reference

    override fun findAllByUser(userid: String, habitList: MutableLiveData<List<HabitModel>>) {
        database.child("user-habits").child(userid)
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    Timber.i("Firebase Habit error : ${error.message}")
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    val localList = ArrayList<HabitModel>()
                    val children = snapshot.children
                    children.forEach {
                        val habit = it.getValue(HabitModel::class.java)
                        localList.add(habit!!)
                    }
                    database.child("user-habits").child(userid)
                        .removeEventListener(this)

                    habitList.value = localList
                }
            })
    }

    override fun findById(userid: String, habitId: String, habit: MutableLiveData<HabitModel>){

        database.child("user-habits").child(userid)
            .child(habitId).get().addOnCompleteListener {
                if (it.isSuccessful) {
                    habit.value = it.result.getValue(HabitModel::class.java)
                    Timber.i("firebase Got value ${habit.value}")
                }
                else {
                    Timber.e("firebase Error getting data ${it.result.getValue()}")
                }
            }.addOnFailureListener{
                Timber.e("firebase Error getting data $it")
            }

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
        // childAdd["/habits/$key"] = habitValues
        childAdd["/user-habits/$uid/$key"] = habitValues // "save" habit for user

        database.updateChildren(childAdd)
    }

    override fun delete(userid: String, habitId: String) {

        val childDelete : MutableMap<String, Any?> = HashMap()
        childDelete["/user-habits/$userid/$habitId"] = null

        database.updateChildren(childDelete)
    }

    override fun update(userid: String, habitId: String, habit: HabitModel) {

        val habitValues = habit.toMap()

        val childUpdate : MutableMap<String, Any?> = HashMap()
        childUpdate["user-habits/$userid/$habitId"] = habitValues

        database.updateChildren(childUpdate)
    }
}