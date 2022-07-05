package org.othr.habithunter.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import org.othr.habithunter.firebase.FirebaseDBManager
import org.othr.habithunter.models.HabitManager
import java.util.*


class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {

        // What do do, if alarm gets received at midnight?
        val cal: Calendar = Calendar.getInstance()

        val isFirstOfWeek = isFirstDayofWeek(cal)
        val isFirstOfMonth = isFirstDayofMonth(cal)

        // HabitManager.resetHabits(isFirstOfWeek, isFirstOfMonth)
        FirebaseDBManager.resetHabitProgress(isFirstOfWeek, isFirstOfMonth)

    }

    // -> reset monthly habits
    fun isFirstDayofMonth(calendar: Calendar?): Boolean {
        requireNotNull(calendar) { "Calendar cannot be null." }
        val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
        return dayOfMonth == 1
    }

    // -> reset weekly habits
    fun isFirstDayofWeek(calendar: Calendar?): Boolean {
        requireNotNull(calendar) { "Calendar cannot be null." }
        val dayOfWeek = calendar[Calendar.DAY_OF_WEEK]
        return dayOfWeek == 1
    }

}