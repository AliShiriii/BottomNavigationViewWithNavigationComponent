package com.example.testapplication.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Property(
    val Name: String,
    val PropertyId: Int,
    val Value: String
): Parcelable