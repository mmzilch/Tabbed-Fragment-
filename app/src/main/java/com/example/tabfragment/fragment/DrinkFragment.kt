package com.example.tabfragment.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tabfragment.R
import com.example.tabfragment.adapter.FoodItemAdapter
import com.example.tabfragment.viewmodel.FoodViewModel
import kotlinx.android.synthetic.main.fragment_curry.*
import kotlinx.android.synthetic.main.fragment_drink.*

class DrinkFragment : Fragment() {

    private lateinit var foodItemViewModel: FoodViewModel
    private lateinit var foodAdapter: FoodItemAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(context)
        foodAdapter = FoodItemAdapter()
        rcyDrink.apply {
            adapter = foodAdapter
            layoutManager = viewManager
            observeViewModel()
        }
    }

    private fun observeViewModel() {
        foodItemViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
        foodItemViewModel.detailResult.observe(
            viewLifecycleOwner, Observer {
                Log.d("foodList>>>>", it.food.toString())
                tvDrinkError.visibility = View.GONE
                rcyDrink.visibility = View.VISIBLE
                foodAdapter.updateFoodItemList(it.food)
                //foodAdapter.setClickListener(this)
            }
        )

        foodItemViewModel.getError().observe(
            viewLifecycleOwner, Observer {
                if (it) {
                    tvDrinkError.visibility = View.VISIBLE
                    rcyDrink.visibility = View.GONE
                } else {
                    tvDrinkError.visibility = View.GONE
                    rcyDrink.visibility = View.VISIBLE
                }
            }
        )
    }

    override fun onResume() {
        super.onResume()
        foodItemViewModel.loadFoodItemsResult(3)
    }

}