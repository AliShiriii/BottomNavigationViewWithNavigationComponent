package com.example.testapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetContent(

    val accessLevelTypeID: Int,
    val authors: String,
    val categories: List<Category>,
    val collectionImage: String,
    val commentCount: Int,
    val contentID: Int,
    val createDate: Int,
    val disLikeCount: Int,
    val disLikeStatus: Boolean,
    val duration: Int,
    val englishBody: Any,
    val favoriteStatus: Boolean,
    val landscapeImage: String,
    val landscapeImage9X4: String,
    val likeCount: Int,
    val likeStatus: Boolean,
    val portraitImage: String,
    val portraitImage9X11: String,
    val price: Double,
    val properties: List<Property>,
    val purchasedPrice: Double,
    val sourceSiteLogoUrl: String,
    val sourceSiteTitle: String,
    val sourceSiteWebUrl: String,
    val summary: String,
    val supplierID: Int,
    val tagList: List<Tag>,
    val teacherList: List<Any>,
    val thumbImage: String,
    val title: String,
    val type: Int,
    val updateDate: Int,
    val viewCount: Int,
    val zoneID: Int

    )