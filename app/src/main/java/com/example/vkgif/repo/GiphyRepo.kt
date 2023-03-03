package com.example.vkgif.repo

import com.example.vkgif.network.Api


class GiphyRepo(private val service: Api) {

    suspend fun getGiphy() = service.getGiphy()

    suspend fun getSearchGiphy(q:String = "test") = service.getSearchGiphy(q)
}