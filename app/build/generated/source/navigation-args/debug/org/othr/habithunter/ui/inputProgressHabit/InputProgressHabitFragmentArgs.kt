package org.othr.habithunter.ui.inputProgressHabit

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class InputProgressHabitFragmentArgs(
  public val habitId: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("habitId", this.habitId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("habitId", this.habitId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): InputProgressHabitFragmentArgs {
      bundle.setClassLoader(InputProgressHabitFragmentArgs::class.java.classLoader)
      val __habitId : String?
      if (bundle.containsKey("habitId")) {
        __habitId = bundle.getString("habitId")
        if (__habitId == null) {
          throw IllegalArgumentException("Argument \"habitId\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"habitId\" is missing and does not have an android:defaultValue")
      }
      return InputProgressHabitFragmentArgs(__habitId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        InputProgressHabitFragmentArgs {
      val __habitId : String?
      if (savedStateHandle.contains("habitId")) {
        __habitId = savedStateHandle["habitId"]
        if (__habitId == null) {
          throw IllegalArgumentException("Argument \"habitId\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"habitId\" is missing and does not have an android:defaultValue")
      }
      return InputProgressHabitFragmentArgs(__habitId)
    }
  }
}
