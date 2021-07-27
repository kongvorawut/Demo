package com.example.demoappfornewjoiner.model


import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("url")
    val url: String = "",
    @SerializedName("webpurl")
    val webpUrl: String = "",
    @SerializedName("x")
    val x: Double = 0.0,
    @SerializedName("y")
    val y: Double = 0.0
)