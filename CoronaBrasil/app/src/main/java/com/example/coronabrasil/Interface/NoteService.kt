package com.example.coronabrasil.Interface

import com.example.coronabrasil.DataResponse
import com.example.coronabrasil.Model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NoteService {

    @GET("brazil")
    fun listDatas(
        @Query("state") state: String = "",
        @Query("cases") cases: Int = 1,
        @Query("suspects") suspects: Int = 1
    ) : Call<DataResponse>
}