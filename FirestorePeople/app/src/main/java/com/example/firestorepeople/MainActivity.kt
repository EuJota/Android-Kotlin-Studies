package com.example.firestorepeople

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.firestorepeople.Adapters.MyFragmentPagerAdapter
import com.example.firestorepeople.Fragments.FirstFragment
import com.example.firestorepeople.Fragments.MyFragment
import com.example.firestorepeople.Fragments.SecondFragment
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayout

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initViews()

        initTabLayout()

        setupViewPager()
    }

    private fun setupViewPager() {

        val adapter = MyFragmentPagerAdapter(this, supportFragmentManager, tabs.tabCount)
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

        })
    }

    private fun initViews() {
        tabs = findViewById(R.id.tablayout)
        viewPager = findViewById(R.id.view_pager_container)
    }

    private fun initTabLayout(){
        tabs.addTab(tabs.newTab().setText("Pessoas"))
        tabs.addTab(tabs.newTab().setText("Favoritos"))
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
