package org.othr.habithunter.models

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.net.URI

@Parcelize
data class HabitModel(
    var habitId: String = "N/A",
    var habitTitle: String = "N/A",
    var habitImage: Uri = Uri.EMPTY,
    var habitGoal: Int = 0,
    var habitProgress: Int = 0,
    var habitIntervall: HabitIntervall = HabitIntervall.MONTHLY,
    var habitUnit: String = "count") : Parcelable