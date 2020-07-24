package com.example.tabfragment.api

import com.example.tabfragment.model.Food
import com.example.tabfragment.model.FoodCategories
import com.example.tabfragment.model.FoodItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @GET("category")
    fun getCategories(): Call<FoodCategories>

    @GET("filterByCategory")
    fun getFoodItemDetails(
        @Query("category_id") categoryId : Int
    ): Call<FoodItem>

    @POST("food")
    fun addNewFoodItem(
        @Query("food_name") foodName : String,
        @Query("calories") newFoodCalories: String,
        @Query("category") categoryId: Int
    ) : Call<Food>

    @GET("searchByName")
    fun searchFood(
        @Query("search_name")
        s:String): Call<FoodItem>
}