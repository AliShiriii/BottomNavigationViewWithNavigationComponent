package com.example.testapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(

    val ageRangeId: Any,
    val categoryID: Int,
    val defaultImage: String,
    val image: String,
    val isFollowed: Boolean,
    val isSelected: Boolean,
    val parentID: Int,
    val sectionPriority: Int,
    val title: String,
    val zoneID: Int
)