package com.xpayback.machinetest.models.users


import com.google.gson.annotations.SerializedName

data class UsersListResponse(
    @SerializedName("users")
    val users: List<User>?
)