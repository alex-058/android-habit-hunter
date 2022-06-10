package org.othr.habithunter.models

interface IHabitCrud {
    fun create (habit: HabitModel)
    fun getHabits() : List<HabitModel>
    fun getHabitById(id: String) : HabitModel?
    fun delete (id: String)
    fun update (id: String, habit: HabitModel) // id and updated model
}