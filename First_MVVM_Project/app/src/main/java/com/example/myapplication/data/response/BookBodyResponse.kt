package com.example.myapplication.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// Anotação para geração do boilerplate de conversão de dto para json e vice versa
@JsonClass(generateAdapter = true)
data class BookBodyResponse (
    //fazendo mapeamento dos recursos da api utilizando o mapeamento de recursos do moshi
    @Json(name = "results")
    val bookResuls: List<BookResultsResponse>
)