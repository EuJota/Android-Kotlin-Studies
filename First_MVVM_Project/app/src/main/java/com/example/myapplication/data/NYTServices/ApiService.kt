package com.example.myapplication.data.NYTServices

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// Definir uma classe como object no kotlin torna ela uma singleton
// Isso serve para evitar a criação de várias instâncias da classe
object ApiService {

    private fun initRetrofit()  : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/books/v3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service = initRetrofit().create(NYTServices::class.java)
}