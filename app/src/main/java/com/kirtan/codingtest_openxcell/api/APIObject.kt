package com.kirtan.codingtest_openxcell.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object APIObject {

    private const val BASE_URL = "http://randomuser.me/"

    @Volatile
    private var instance: API? = null

    fun getInstance(): API {
        return instance ?: synchronized(this) {
            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(API::class.java)
            instance!!
        }
    }
}