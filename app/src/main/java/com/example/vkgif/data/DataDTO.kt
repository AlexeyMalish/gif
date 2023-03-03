package com.example.vkgif.data

import com.google.gson.annotations.SerializedName

data class DataDTO(
    @SerializedName("data")
    val listOfGif: ArrayList<GifDTO>
)