package com.example.vkgif.data.searchGiphyModels

import com.example.vkgif.data.GifDTO
import com.google.gson.annotations.SerializedName

data class DataSearchDTO (

    @SerializedName("data")
    val searchList : ArrayList<GifDTO>
)