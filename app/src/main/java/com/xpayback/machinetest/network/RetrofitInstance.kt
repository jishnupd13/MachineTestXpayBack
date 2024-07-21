package com.xpayback.machinetest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

object RetrofitInstance {
    var retrofitService: ApiService? = null
    fun getInstance() : ApiService {
        if (retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofitService = retrofit.create(ApiService::class.java)
        }
        return retrofitService!!
    }
}