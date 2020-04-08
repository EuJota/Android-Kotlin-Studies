package com.example.firestorepeople.Fragments

import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.firestorepeople.R

/**
 * A simple [Fragment] subclass.
 */
class MyFragment : Fragment() {
    companion object{
        fun NewInstance(message: String): MyFragment{
            val f = MyFragment()
            val bdl = Bundle(1)

            bdl.putString(EXTRA_MESSAGE, message)

            f.setArguments(bdl)

            return f
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

}
