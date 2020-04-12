package com.example.firestorepeople.Persistence

import android.content.Context
import com.example.firestorepeople.Model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DataPersistence {

    private var favoritePeopleList: MutableList<List<User>> = mutableListOf()
    private var favoritePeopleIds: MutableList<Int> = mutableListOf()

    fun setFavoritePerson(id: Int?, context: Context?): Boolean{
        if(favoritePeopleIds.any { e -> e == id}){
            favoritePeopleIds.remove(id!!)
            savePerson(
                context!!
            )
            return false
        }else{
            favoritePeopleIds.add(id!!)
            savePerson(
                context!!
            )
            System.out.println("Tudo certo")
            return true
        }
    }

    fun savePerson(context: Context?){
        val sharedPreferences = context?.getSharedPreferences("people_list", 0)

        sharedPreferences?.let {
            val editor = sharedPreferences.edit()
            val gson = Gson()
            val json = gson.toJson(favoritePeopleIds)

            json?.let {
                editor?.putString("favorite list", json)
                editor?.apply()
            }
        }
    }

    fun showFavoritePerson(context: Context?){
        val sharedPreferences = context?.getSharedPreferences("people_list", 0)

        sharedPreferences?.let {
            val gson = Gson()
            val json = sharedPreferences.getString("favorite list", null)
            val type = object : TypeToken<MutableList<Int>>(){}.type

            json?.let { favoritePeopleIds = gson.fromJson(json, type) }
        }
    }

}