package com.example.vkgif.network

import com.example.vkgif.data.DataDTO
import com.example.vkgif.data.searchGiphyModels.DataSearchDTO
import com.example.vkgif.util.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("v1/gifs/trending")
    suspend fun getGiphy(
        @Query("api_key")key:String = Constant.key,
        @Query("limit")limit:String = Constant.limit,
        @Query("rating")rating:String = Constant.rating
    ): DataDTO

    @GET("v1/gifs/search")
    suspend fun getSearchGiphy(
        @Query("q")q:String,
        @Query("api_key")key:String = Constant.key,
        @Query("limit")limit:String ="25",
        @Query("offset")offset:String = "0",
        @Query("rating")rating:String = Constant.rating,
        @Query("lang")lang:String = "en"
    ): DataSearchDTO
}


