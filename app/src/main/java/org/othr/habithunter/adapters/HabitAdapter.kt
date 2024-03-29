package org.othr.habithunter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
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
        val habit = habits[holder.bindingAdapterPosition]
        holder.bind(habit,listener)
    }

    fun removeAt(position: Int) {
        habits.removeAt(position) // removes the habit from the list
        notifyItemRemoved(position) // this also restructures the data set (elements in our list which are at that position or after it)
    }

    override fun getItemCount(): Int = habits.size

    inner class MainHolder(val binding : CardviewHabitsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: HabitModel, listener: HabitClickListener) {
            binding.root.tag = habit
            binding.habit = habit
            binding.root.setOnClickListener { listener.onHabitClick(habit) }
            binding.executePendingBindings()
            Picasso.get().load(habit.habitImage.toUri())
                .resize(200, 200)
                .centerCrop()
                .into(binding.image)

        }
    }
}