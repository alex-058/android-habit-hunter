package org.othr.habithunter.models

interface IHabitCrud {
    fun create (habit: HabitModel)
    fun findAll() : ArrayList<HabitModel>
}