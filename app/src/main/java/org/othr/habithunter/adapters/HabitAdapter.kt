package org.othr.habithunter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.othr.habithunter.R
import org.othr.habithunter.databinding.CardviewHabitsBinding
import org.othr.habithunter.models.HabitModel

interface HabitClickListener {
    fun onHabitClick(habit: HabitModel)
}

class HabitAdapter constructor(private var habits: ArrayList<HabitModel>,
                                  private val listener: HabitClickListener)
    : RecyclerView.Adapter<HabitAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardviewHabitsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val habit = habits[holder.adapterPosition]
        holder.bind(habit,listener)
    }

    fun removeAt(position: Int) {
        habits.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int = habits.size

    inner class MainHolder(val binding : CardviewHabitsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: HabitModel, listener: HabitClickListener) {
            binding.habit = habit
            binding.image.setImageResource(R.mipmap.ic_launcher_round)
            binding.root.setOnClickListener { listener.onHabitClick(habit) }
            binding.executePendingBindings()
        }
    }
}