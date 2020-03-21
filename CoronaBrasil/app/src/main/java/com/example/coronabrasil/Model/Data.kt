package com.example.coronabrasil.Model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("state")
    val state : String,
    @SerializedName("cases")
    val cases : Int,
    @SerializedName("suspects")
    val suspects : Int
)