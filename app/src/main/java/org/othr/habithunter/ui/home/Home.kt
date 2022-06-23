package org.othr.habithunter.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.othr.habithunter.R
import org.othr.habithunter.databinding.ActivityHomeBinding
import org.othr.habithunter.ui.profile.LoggedInViewModel


class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_dashboard, R.id.navigation_stats, R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Trigger fullscreen support
        navController.addOnDestinationChangedListener {
                _, destination, _ ->
            if (destination.id == R.id.addCustomHabitFragment || destination.id == R.id.navigation_profile) {
                navView.visibility = View.GONE
            } else {
                navView.visibility = View.VISIBLE
            }
        }


    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}