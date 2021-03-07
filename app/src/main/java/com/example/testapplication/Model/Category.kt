package com.example.testapplication.Model

import android.os.Parcelable
import androidx.paging.PagingData
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val AgeRangeId: String,
    val CategoryID: Int,
    val DefaultImage: String,
    val Image: String,
    val IsFollowed: Boolean,
    val IsSelected: Boolean,
    val ParentID: Int,
    val SectionPriority: Int,
    val Title: String,
    val ZoneID: Int
): Parcelable