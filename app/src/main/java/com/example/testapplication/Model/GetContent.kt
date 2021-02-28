package com.example.testapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetContent(

    @SerializedName("accessLevelTypeID")
    @Expose
    val accessLevelTypeID: Int,

    @SerializedName("authors")
    @Expose
    val authors: String,

    @SerializedName("categories")
    @Expose
    val categories: List<Category>,

    @SerializedName("collectionImage")
    @Expose
    val collectionImage: String,

    @SerializedName("commentCount")
    @Expose
    val commentCount: Int,

    @SerializedName("contentID")
    @Expose
    val contentID: Int,

    @SerializedName("createDate")
    @Expose
    val createDate: Int,

    @SerializedName("disLikeCount")
    @Expose
    val disLikeCount: Int,

    @SerializedName("disLikeStatus")
    @Expose
    val disLikeStatus: Boolean,

    @SerializedName("duration")
    @Expose
    val duration: Int,

    @SerializedName("englishBody")
    @Expose
    val englishBody: Any,

    @SerializedName("favoriteStatus")
    @Expose
    val favoriteStatus: Boolean,

    @SerializedName("landscapeImage")
    @Expose
    val landscapeImage: String,

    @SerializedName("landscapeImage9X4")
    @Expose
    val landscapeImage9X4: String,

    @SerializedName("likeCount")
    @Expose
    val likeCount: Int,

    @SerializedName("likeStatus")
    @Expose
    val likeStatus: Boolean,

    @SerializedName("portraitImage")
    @Expose
    val portraitImage: String,

    @SerializedName("portraitImage9X11")
    @Expose
    val portraitImage9X11: String,

    @SerializedName("price")
    @Expose
    val price: Double,

    @SerializedName("properties")
    @Expose
    val properties: List<Property>,

    @SerializedName("purchasedPrice")
    @Expose
    val purchasedPrice: Double,

    @SerializedName("sourceSiteLogoUrl")
    @Expose
    val sourceSiteLogoUrl: String,

    @SerializedName("sourceSiteTitle")
    @Expose
    val sourceSiteTitle: String,

    @SerializedName("sourceSiteWebUrl")
    @Expose
    val sourceSiteWebUrl: String,

    @SerializedName("summary")
    @Expose
    val summary: String,

    @SerializedName("supplierID")
    @Expose
    val supplierID: Int,

    @SerializedName("tagList")
    @Expose
    val tagList: List<Tag>,

    @SerializedName("teacherList")
    @Expose
    val teacherList: List<Any>,

    @SerializedName("thumbImage")
    @Expose
    val thumbImage: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("type")
    @Expose
    val type: Int,

    @SerializedName("updateDate")
    @Expose
    val updateDate: Int,

    @SerializedName("viewCount")
    @Expose
    val viewCount: Int,

    @SerializedName("zoneID")
    @Expose
    val zoneID: Int

    )