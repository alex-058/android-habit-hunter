package org.othr.habithunter.models

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

object HabitManager : IHabitCrud {

    private var habits = ArrayList<HabitModel>() // holds data of habits

    init {
        // sample data
        create(HabitModel(habitTitle = "Steps", habitGoal = 2000, habitIntervall = HabitIntervall.DAILY))
        create(HabitModel(habitTitle = "Swim", habitGoal = 7, habitIntervall = HabitIntervall.MONTHLY))
    }

    override fun create(habit: HabitModel) {
        habit.habitId = getId().toString() // set id for habit
        habits.add(habit)
    }

    override fun getHabits(): ArrayList<HabitModel> {
        return habits
    }

    override fun getHabitById(id: String): HabitModel? {
        val habit: HabitModel? = habits.find { it.habitId == id }
        return habit
    }


}