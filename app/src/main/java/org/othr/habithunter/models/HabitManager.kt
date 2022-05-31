package org.othr.habithunter.models

object HabitManager : IHabitCrud {

    private var habits = ArrayList<HabitModel>() // holds data of habits

    override fun create(habit: HabitModel) {
        habits.add(habit)
    }

    override fun getHabits(): ArrayList<HabitModel> {
        return habits
    }


}