package org.othr.habithunter.models

import android.net.Uri
import android.os.Parcelable
import com.google.firebase.database.Exclude
import kotlinx.parcelize.Parcelize
import java.net.URI

@Parcelize
data class HabitModel(
    var uid: String = "N/A",
    var email: String? = "N/A",
    var habitTitle: String = "N/A",
    var habitImage: Uri = Uri.EMPTY,
    var habitGoal: Int = 0,
    var habitProgress: Int = 0,
    var habitIntervall: HabitIntervall = HabitIntervall.MONTHLY,
    var habitUnit: String = "count") : Parcelable

{
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "uid" to uid,
            "habitTitle" to habitTitle,
            "habitGoal" to habitGoal,
            "habitProgress" to habitProgress,
            "habitIntervall" to habitIntervall,
            "habitUnit" to habitUnit,
            "email" to email
        )
    }
}