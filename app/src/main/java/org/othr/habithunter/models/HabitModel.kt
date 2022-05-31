package org.othr.habithunter.models

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.net.URI

@Parcelize
data class HabitModel(
    var habitTitle: String = "N/A",
    var habitImage: Uri = Uri.EMPTY) : Parcelable