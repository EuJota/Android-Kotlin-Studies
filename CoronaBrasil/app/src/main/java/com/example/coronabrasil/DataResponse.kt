package com.example.coronabrasil

import com.example.coronabrasil.Model.Data
import com.google.gson.annotations.SerializedName

data class DataResponse (
    @SerializedName("values")
    val dataResults : List<Data>
)