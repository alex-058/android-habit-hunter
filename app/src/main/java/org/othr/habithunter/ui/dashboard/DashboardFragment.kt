package org.othr.habithunter.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.othr.habithunter.R
import org.othr.habithunter.databinding.FragmentDashboardBinding
import org.othr.habithunter.models.HabitModel
import org.othr.habithunter.adapters.HabitAdapter
import org.othr.habithunter.adapters.HabitClickListener

class DashboardFragment : Fragment(), HabitClickListener {

    private var _binding: FragmentDashboardBinding? = null

    lateinit var dashboardViewModel: DashboardViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_dashboard_to_addCustomHabitFragment)
        }

        binding.habitRecyclerView.layoutManager = LinearLayoutManager(activity)

        dashboardViewModel.observableHabitList.observe(viewLifecycleOwner, Observer {
                habits ->
            habits?.let {
                render(habits as ArrayList<HabitModel>)
            }
        })

        /*val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        dashboardViewModel.load() // syncs the list hopefully
    }

    private fun render(habitList: ArrayList<HabitModel>) {
        binding.habitRecyclerView.adapter = HabitAdapter(habitList,this)
        if (habitList.isEmpty()) {
            binding.habitRecyclerView.visibility = View.GONE
            // fragBinding.habitsNotFound.visibility = View.VISIBLE
        } else {
            binding.habitRecyclerView.visibility = View.VISIBLE
            // fragBinding.habitsNotFound.visibility = View.GONE
        }
    }

    override fun onHabitClick(habit: HabitModel) {
        // event handling for clicking a habit in recycler view
        // Toast.makeText(activity, "You just clicked the habit: " + habit.habitTitle + habit.habitId, Toast.LENGTH_LONG)
        // .show()
        // findNavController().navigate(R.id.action_navigation_dashboard_to_inputProgressHabit)

        val action = DashboardFragmentDirections.actionNavigationDashboardToInputProgressHabit(habit.habitId)
        findNavController().navigate(action)
    }
}

