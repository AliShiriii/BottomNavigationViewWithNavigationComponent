package com.example.testapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(

    @SerializedName("ageRangeId")
    @Expose
    val ageRangeId: Any,

    @SerializedName("categoryID")
    @Expose
    val categoryID: Int,

    @SerializedName("defaultImage")
    @Expose
    val defaultImage: String,

    @SerializedName("image")
    @Expose
    val image: String,

    @SerializedName("isFollowed")
    @Expose
    val isFollowed: Boolean,

    @SerializedName("isSelected")
    @Expose
    val isSelected: Boolean,

    @SerializedName("parentID")
    @Expose
    val parentID: Int,

    @SerializedName("sectionPriority")
    @Expose
    val sectionPriority: Int,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("zoneID")
    @Expose
    val zoneID: Int
)