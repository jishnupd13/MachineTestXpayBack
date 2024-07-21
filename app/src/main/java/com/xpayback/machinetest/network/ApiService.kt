package com.xpayback.machinetest.network

import com.xpayback.machinetest.models.network_result.NetworkResult
import com.xpayback.machinetest.models.users.UsersListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users?limit={limit}&skip={skip}")
    suspend fun fetchUsers(
        @Path("limit") limit: Int,
        @Path("skip") skip: Int
    ): Response<NetworkResult<UsersListResponse>>
}