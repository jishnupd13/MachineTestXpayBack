package com.xpayback.machinetest.network

import com.xpayback.machinetest.models.users.UsersListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users?")
    suspend fun fetchUsers(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): Response<UsersListResponse>
}