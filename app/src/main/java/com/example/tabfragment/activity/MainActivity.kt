package com.example.tabfragment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tabfragment.R
import com.example.tabfragment.adapter.TabAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabAdapter =
            TabAdapter(supportFragmentManager)
        viewpager_main.adapter = tabAdapter
        tabs_main.setupWithViewPager(viewpager_main)
    }
}