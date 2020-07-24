package com.example.tabfragment.api

import com.example.tabfragment.model.Food
import com.example.tabfragment.model.FoodCategories
import com.example.tabfragment.model.FoodItem
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {
    private val apiInterface: ApiInterface

    companion object {
        const val Base_URL = "https://healthfitness.khaingthinkyi.me/api/"
    }

    init {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        //when create class obj and it create retrofits
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getCategories(): Call<FoodCategories> {
        return apiInterface.getCategories()
    }

    fun getFoodItem(id: Int): Call<FoodItem> {
        return apiInterface.getFoodItemDetails(id)
    }

    fun addNewFoodItem(foodName: String, newFoodCalories: String, category: Int): Call<Food> {
        return apiInterface.addNewFoodItem(foodName, newFoodCalories, category)
    }

    fun serachfood(s: String): Call<FoodItem> {
        return apiInterface.searchFood(s)
    }
}