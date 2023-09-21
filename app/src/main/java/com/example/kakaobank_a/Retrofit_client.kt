package com.example.kakaobank_a


import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object retrofit_client {

    val apiService: KaKaoAPI
        get() = instance.create(KaKaoAPI::class.java)

    private val instance: Retrofit
        private get() {
            val gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL) // 기본 URL
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
}