package com.example.tabfragment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val category_image: String,
    val category_name: String,
    val category_id: Int
):Parcelable