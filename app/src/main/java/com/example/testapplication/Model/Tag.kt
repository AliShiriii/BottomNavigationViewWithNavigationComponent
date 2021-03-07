package com.example.testapplication.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tag(
    val BackgroundImage: String,
    val Description: String,
    val Image: String,
    val IsFollowed: Boolean,
    val IsSelected: Boolean,
    val Name: String,
    val SectionPriority: Int,
    val TagId: Int
): Parcelable