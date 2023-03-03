package com.example.vkgif.data

import com.google.gson.annotations.SerializedName

data class GifDTO(

    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("source")
    val source: String,

    @SerializedName("import_datetime")
    val date: String,

    @SerializedName("images")
    val images : ImagesDTO
    )