package com.example.firestorepeople.Adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.firestorepeople.Fragments.FirstFragment
import com.example.firestorepeople.Fragments.SecondFragment

// REFATORAR PARA TIRAR O LAÇO E COLOCAR UM ARRAYLIST, ACREDITO QUE É A FORMA MAIS CLEAN DE FAZER ISSO

class MyFragmentPagerAdapter (val context: Context, fragmentManager: FragmentManager, internal var totalTabs: Int) :
        FragmentPagerAdapter(fragmentManager){


    override fun getItem(position: Int): Fragment {
        when(position){
            0-> return FirstFragment()
            1-> return SecondFragment()
            else -> return FirstFragment()
        }
    }

    override fun getCount() = totalTabs

}




