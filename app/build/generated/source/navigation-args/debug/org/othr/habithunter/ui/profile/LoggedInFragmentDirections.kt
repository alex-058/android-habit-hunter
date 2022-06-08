package org.othr.habithunter.ui.profile

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import org.othr.habithunter.R

public class LoggedInFragmentDirections private constructor() {
  public companion object {
    public fun actionLoggedInFragmentToNavigationProfile(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loggedInFragment_to_navigation_profile)
  }
}
