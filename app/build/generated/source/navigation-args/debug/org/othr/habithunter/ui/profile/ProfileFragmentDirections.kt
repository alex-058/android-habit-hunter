package org.othr.habithunter.ui.profile

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import org.othr.habithunter.R

public class ProfileFragmentDirections private constructor() {
  public companion object {
    public fun actionNavigationProfileToLoggedInFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_profile_to_loggedInFragment)
  }
}
