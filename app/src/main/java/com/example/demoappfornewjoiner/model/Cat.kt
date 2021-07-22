package com.example.demoappfornewjoiner.model


import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("id")
    val id: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("webpurl")
    val webpUrl: String,
    @SerializedName("x")
    val x: Double,
    @SerializedName("y")
    val y: Double
)