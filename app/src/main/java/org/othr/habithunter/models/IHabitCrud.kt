package org.othr.habithunter.models

interface IHabitCrud {
    fun create (habit: HabitModel)
    fun getHabits() : ArrayList<HabitModel>
    fun getHabitById(id: String) : HabitModel?
    fun delete (habit: HabitModel)
    fun update (id: String, habit: HabitModel) // id and updated model
}