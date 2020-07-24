package com.example.tabfragment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tabfragment.api.Api
import com.example.tabfragment.model.Category
import com.example.tabfragment.model.FoodCategories
import com.example.tabfragment.model.FoodItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodViewModel : ViewModel() {

   /* var categoryResults: MutableLiveData<List<Category>> = MutableLiveData()
    fun getResults(): LiveData<List<Category>> = categoryResults*/

    var detailResult: MutableLiveData<FoodItem> = MutableLiveData()
    fun getDetails(): LiveData<FoodItem> = detailResult

   /* var searchFood : MutableLiveData<FoodItem> = MutableLiveData()
    fun getSearchFood() : LiveData<FoodItem> = searchFood*/

    var resultLoadError : MutableLiveData<Boolean> = MutableLiveData()
    fun getError() : LiveData<Boolean> = resultLoadError
    var loading : MutableLiveData<Boolean> = MutableLiveData()
    fun getLoading() : LiveData<Boolean> = loading

    private val foodApi: Api = Api()

    /*fun loadCategoriesResult() {
        loading.value = true
        val apiCall = foodApi.getCategories()
        apiCall.enqueue(object : Callback<FoodCategories> {

            override fun onFailure(call: Call<FoodCategories>, t: Throwable) {
                resultLoadError.value = true
                loading.value = false
            }

            override fun onResponse(call: Call<FoodCategories>, response: Response<FoodCategories>) {
                response.isSuccessful.let {
                    loading.value = false
                    val resultList:List<Category> = response.body()?.categories?: emptyList()
                    categoryResults.value = resultList
                }
            }
        })
    }*/

    fun loadFoodItemsResult(id: Int) {
        //Log.d("loadItemResult>>>>",id.toString())
        loading.value = true
        val apiCall = foodApi.getFoodItem(id)
        apiCall.enqueue(object : Callback<FoodItem> {

            override fun onFailure(call: Call<FoodItem>, t: Throwable) {
                resultLoadError.value = true
                loading.value = false
            }

            override fun onResponse(call: Call<FoodItem>, response: Response<FoodItem>) {
                response.isSuccessful.let {
                    loading.value = false
                    detailResult.value = response.body()
                    Log.d("DetailResult>>>>>",response.body().toString())
                }
            }
        })
    }

    /*fun loadSearchFood(search : String){
        loading.value = true
        val apiCall = foodApi.serachfood(search)
        apiCall.enqueue(object : Callback<FoodItem> {
            override fun onFailure(call: Call<FoodItem>, t: Throwable) {
                resultLoadError.value = false
                loading.value = true
            }

            override fun onResponse(call: Call<FoodItem>, response: Response<FoodItem>) {
                loading.value = false
                searchFood.value  = response.body()
            }
        })
    }*/
}