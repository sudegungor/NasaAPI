package com.sude.nasaapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sude.nasaapi.R
import com.sude.nasaapi.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabs()


    }

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HepsiniGoruntuleFragment(), "All")
        adapter.addFragment(OpportunityFragment(), "Opportunity")
        adapter.addFragment(CuriosityFragment(), "Curiosity")
        adapter.addFragment(SpiritFragment(), "Spirit")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

    }
}