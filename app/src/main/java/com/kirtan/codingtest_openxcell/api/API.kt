package com.kirtan.codingtest_openxcell.api

import com.kirtan.codingtest_openxcell.model.APIModel
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface API {

    @POST("api/")
    fun getUsers(@Query("results") size: Int): Call<APIModel>

}