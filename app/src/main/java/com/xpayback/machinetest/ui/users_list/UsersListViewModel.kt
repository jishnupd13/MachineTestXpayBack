package com.xpayback.machinetest.ui.users_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xpayback.machinetest.models.network_result.NetworkResult
import com.xpayback.machinetest.models.users.UsersListResponse
import com.xpayback.machinetest.repository.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersListViewModel(val repository: AppRepository) :ViewModel() {

    var skip = 0
    var limit = 10
    val _usersResponseMutableLiveDate = MutableLiveData<NetworkResult<UsersListResponse>>()
    val userResponseLiveData: LiveData<NetworkResult<UsersListResponse>> = _usersResponseMutableLiveDate

    fun fetchUsers() = viewModelScope.launch(Dispatchers.IO){
        try {
            val response = repository.fetchUsers(limit = limit, skip = skip)
            if (response.isSuccessful){
                _usersResponseMutableLiveDate.value = NetworkResult.Success(response.body()?.data!!)
            }else{
                _usersResponseMutableLiveDate.value = NetworkResult.Error(response.errorBody().toString())
            }
        }catch (e: Exception){
            _usersResponseMutableLiveDate.value = NetworkResult.Error(e.message.toString())
        }
    }
}