package org.othr.habithunter.ui.dashboard

import android.app.AlarmManager
import android.app.AlertDialog
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
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
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.othr.habithunter.R
import org.othr.habithunter.databinding.FragmentDashboardBinding
import org.othr.habithunter.models.HabitModel
import org.othr.habithunter.adapters.HabitAdapter
import org.othr.habithunter.adapters.HabitClickListener
import org.othr.habithunter.alarm.AlarmReceiver
import org.othr.habithunter.ui.profile.LoggedInViewModel
import org.othr.habithunter.utils.*
import java.util.*
import kotlin.collections.ArrayList

class DashboardFragment : Fragment(), HabitClickListener {

    private var _binding: FragmentDashboardBinding? = null

    lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var loggedInViewModel : LoggedInViewModel

    lateinit var loader : AlertDialog

    // Alarm support
    private var alarmMgr: AlarmManager? = null
    private var alarmIntent: PendingIntent? = null

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

        loader = createLoader(requireActivity())

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_dashboard_to_addCustomHabitFragment)
        }

        binding.habitRecyclerView.layoutManager = LinearLayoutManager(activity)

        showLoader(loader,"Downloading Habits")
        dashboardViewModel.observableHabitList.observe(viewLifecycleOwner, Observer {
                habits ->
            habits?.let {
                render(habits as ArrayList<HabitModel>)
                hideLoader(loader)
            }
        })


        // Handle swipe to delete gesture
        val swipeDeleteHandler = object : SwipeToDeleteCallback(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                showLoader(loader,"Deleting Habit")
                val adapter = binding.habitRecyclerView.adapter as HabitAdapter
                // This only needs to be done if we want to delete the habit also from the server / database..,  recycler view does already work with the LIST
                // dashboardViewModel.delete((viewHolder.itemView.tag as HabitModel).habitId)
                adapter.removeAt(viewHolder.bindingAdapterPosition)
                hideLoader(loader)
            }
        }

        val itemTouchDeleteHelper = ItemTouchHelper(swipeDeleteHandler)
        itemTouchDeleteHelper.attachToRecyclerView(binding.habitRecyclerView)

        // Swipe-to-edit feature

        val swipeEditHandler = object : SwipeToEditCallback(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                onHabitSwipeEdit(viewHolder.itemView.tag as HabitModel)
            }
        }
        val itemTouchEditHelper = ItemTouchHelper(swipeEditHandler)
        itemTouchEditHelper.attachToRecyclerView(binding.habitRecyclerView)

        /*val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onStart() {
        super.onStart()

        initializeAlert()

        loggedInViewModel= ViewModelProvider(this).get(LoggedInViewModel::class.java)
        loggedInViewModel.liveFirebaseUser.observe(this, Observer { firebaseUser ->
            if (firebaseUser != null)
                // TODO: check this out
                Toast.makeText(context, "User already logged-in", Toast.LENGTH_SHORT).show()
        })

        loggedInViewModel.loggedOut.observe(this, Observer { loggedout ->
            if (loggedout) {
                    hideLoader(loader)
                // Go to profile fragment
                findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_profile) } })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        showLoader(loader,"Downloading Donations")
        loggedInViewModel.liveFirebaseUser.observe(viewLifecycleOwner, Observer { firebaseUser ->
            if (firebaseUser != null) {
                dashboardViewModel.liveFirebaseUser.value = firebaseUser
                dashboardViewModel.load() // syncs the list
            }
        })
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

        val action = DashboardFragmentDirections.actionNavigationDashboardToInputProgressHabit(habit.uid)
        findNavController().navigate(action)
    }

    private fun onHabitSwipeEdit(habit: HabitModel) {
        val action = DashboardFragmentDirections.actionNavigationDashboardToAddCustomHabitFragment(habit.uid)
        findNavController().navigate(action)
    }

    private fun initializeAlert() {

        if (alarmMgr == null) { // only initialzize if no alarm was initialized before
            alarmMgr = requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(context, AlarmReceiver::class.java)
            alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0)

            // Set the alarm to start at approximately 2:00 p.m.

            // Set the alarm to start now with this configuration
            val calendar: Calendar = Calendar.getInstance()
            calendar.setTimeInMillis(System.currentTimeMillis())
            calendar.set(Calendar.HOUR_OF_DAY, 24) // start alarm at 0:00

            // With setInexactRepeating(), you have to use one of the AlarmManager interval
            // constants--in this case, AlarmManager.INTERVAL_DAY.

            // alarmMgr!!.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
            //     AlarmManager.INTERVAL_FIFTEEN_MINUTES, alarmIntent);

            // Set repeating alarm manager
            alarmMgr!!.setRepeating(
                AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, alarmIntent); // repeat alarm in one day cyclus

            Toast.makeText(context, "Alarm has been initialized!", Toast.LENGTH_LONG).show()
        }

    }
}

