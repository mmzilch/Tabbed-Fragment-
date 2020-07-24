package com.example.tabfragment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tabfragment.R
import com.example.tabfragment.model.Food
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_fooditems.view.*

class FoodItemAdapter : RecyclerView.Adapter<FoodItemAdapter.FoodItemViewHolder>() {

    var mClickListener: ClickListener? = null

    fun setClickListener(clickListener: ClickListener) {
        this.mClickListener = clickListener
    }

    var foodItemList: List<Food> = listOf()

    inner class FoodItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private lateinit var food: Food

        init {itemView.setOnClickListener(this)}

        fun bindMovie(foodItem: Food) {

            var base_url = "https://healthfitness.khaingthinkyi.me/"
            this.food = foodItem
            Picasso.get().load("$base_url${foodItem.food_image}")
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.imgItemFood)//place holder is to show temp image when loading
            itemView.tvItemFoodName.text = foodItem.food_name
            itemView.tvItemFoodName.isSelected = true
            itemView.tvItemFoodCalorie.text = foodItem.calories + " cals"

            Log.d("foodName>>>",food.food_name)
        }

        override fun onClick(v: View?) {
            mClickListener?.onClick(food)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_fooditems, parent, false)
        return FoodItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("foodItmeListSize>>>>>", foodItemList.size.toString())
        return foodItemList.size

    }

    override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) {
        holder.bindMovie(foodItemList[position])
    }

    fun updateFoodItemList(foodItem: List<Food>) {
        this.foodItemList = foodItem
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onClick(food: Food)
    }
}