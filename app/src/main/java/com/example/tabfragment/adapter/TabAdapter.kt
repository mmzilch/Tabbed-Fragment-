package com.example.tabfragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tabfragment.fragment.*

class TabAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FruitFragment()
            }
            1 -> SnackFragment()
            2 -> DrinkFragment()
            3 -> SoupFragment()
            else -> {return CurryFragment()
            }
        }
    }

    override fun getCount(): Int {
            return 5
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Fruit"
            1 -> "Snack"
            2 -> "Drink"
            3 -> "Soup"
            else -> {return "Curry"}
        }
    }

}