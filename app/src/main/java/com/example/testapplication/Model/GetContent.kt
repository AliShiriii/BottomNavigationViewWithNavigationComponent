package com.example.testapplication.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetContent(

    val ContentID: Int,
    val LandscapeImage: String,
    val Summary: String,
    val Title: String

): Parcelable