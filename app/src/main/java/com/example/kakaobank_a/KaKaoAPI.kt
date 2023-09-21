package com.example.kakaobank_a

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KaKaoAPI {
    @GET("v2/search/image")
    fun imagedata(
        @Header("Authorization") apiKey: String?,
        @Query("query") query: String?,
        @Query("sort") sort: String?,
        @Query("page") page: Int,
        @Query("size") size: Int

    ): Call<ImageModel>

}