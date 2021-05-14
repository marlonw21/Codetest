package com.mw21.codetest.data.models.employee

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.io.Serializable
@Parcelize
@Entity
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @Embedded
    val location: Location,
    val mail: String,
    val name: String
): Parcelable