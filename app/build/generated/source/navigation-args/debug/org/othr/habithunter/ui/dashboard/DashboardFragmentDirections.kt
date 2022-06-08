package org.othr.habithunter.ui.dashboard

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String
import org.othr.habithunter.R

public class DashboardFragmentDirections private constructor() {
  private data class ActionNavigationDashboardToInputProgressHabit(
    public val habitId: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_navigation_dashboard_to_inputProgressHabit

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("habitId", this.habitId)
        return result
      }
  }

  public companion object {
    public fun actionNavigationDashboardToAddCustomHabitFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_dashboard_to_addCustomHabitFragment)

    public fun actionNavigationDashboardToInputProgressHabit(habitId: String): NavDirections =
        ActionNavigationDashboardToInputProgressHabit(habitId)

    public fun actionNavigationDashboardToNavigationProfile(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_dashboard_to_navigation_profile)
  }
}
