package com.xpayback.machinetest.repository

import com.xpayback.machinetest.network.ApiService

class AppRepository(private val retrofitService: ApiService) {

    suspend fun fetchUsers(
        limit: Int,
        skip: Int
    ) = retrofitService.fetchUsers(limit, skip)
}