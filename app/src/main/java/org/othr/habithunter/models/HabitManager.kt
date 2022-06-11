package org.othr.habithunter.models

import org.othr.habithunter.adapters.HabitAdapter
import timber.log.Timber

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

object HabitManager : IHabitCrud {

    val habits = ArrayList<HabitModel>() // holds data of habits

    init {
        // sample data
        create(HabitModel(habitTitle = "Steps", habitGoal = 2000, habitIntervall = HabitIntervall.DAILY))
        create(HabitModel(habitTitle = "Swim", habitGoal = 7, habitIntervall = HabitIntervall.MONTHLY))
        create(HabitModel(habitTitle = "Ride", habitGoal = 7, habitIntervall = HabitIntervall.MONTHLY))
    }

    override fun create(habit: HabitModel) {
        habit.habitId = getId().toString() // set id for habit, starts with zero
        habits.add(habit)
        logAll()
    }

    override fun getHabits(): List<HabitModel> {
        return habits
    }

    override fun getHabitById(id: String): HabitModel? {
        val habit: HabitModel? = habits.find { it.habitId == id }
        return habit
    }

    // This is not being triggered at the moment -> Adapter directly removed item from the list
    override fun delete(id: String) {
        habits.removeAt(id.toInt())
        Timber.i("Habit removed from list with id: " + id)
        logAll()
    }

    override fun update(id: String, updatedHabit: HabitModel) {
        habits.set(Integer.parseInt(id), updatedHabit)
    }

    private fun logAll() {
        Timber.v("** Habit List **")
        habits.forEach { Timber.v("Donate ${it}") }
    }
}