package com.example.firestorepeople

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.firestorepeople.Fragments.FirstFragment
import com.example.firestorepeople.Fragments.SecondFragment
import com.google.android.material.badge.BadgeDrawable

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        loadFragment(FirstFragment())

        //PRECISA SETAR UM FRAGMENT COMO DEFAULT PORQUE NAO TA CARREGANDO DE INICIO NO APP

        bottom_navigation_view.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.navigation_home ->{
                    //resources.getString("Favoritos")
                    loadFragment(FirstFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard ->{
                    //resources.getString("Favoritos")
                    loadFragment(SecondFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

        fab.setOnClickListener {
            val intent = Intent(this, CadastrarActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
