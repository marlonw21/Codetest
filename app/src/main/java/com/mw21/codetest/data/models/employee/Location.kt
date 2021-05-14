package com.mw21.codetest.data.models.employee

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    val lat: Double,
    val log: Double
): Parcelable