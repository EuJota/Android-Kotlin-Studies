package com.example.myapplication.data.NYTServices

import com.example.myapplication.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "OIOWnsAA8Hdqz3WYA",
        @Query("list") list : String = "hardcover-fiction"
    ) : Call<BookBodyResponse>

}