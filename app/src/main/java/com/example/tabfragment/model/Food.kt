package com.example.tabfragment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(
    val food_id: Int,
    val calories: String,
    val category: Category,
    val food_image: String,
    val food_name: String

):Parcelable