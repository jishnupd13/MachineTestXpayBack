package com.xpayback.machinetest.ui.users_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xpayback.machinetest.repository.AppRepository

@Suppress("UNCHECKED_CAST")
class UsersLIstViewModelFactory constructor(private val repository: AppRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(UsersListViewModel::class.java)) {
            UsersListViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}