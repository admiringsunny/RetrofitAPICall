package com.learn.retrofitapicall.repository

import com.learn.retrofitapicall.api.UserApiService
import com.learn.retrofitapicall.models.User

class UserRepository(
    val apiService: UserApiService
) {
    suspend fun getUsers(): List<User>{
        return apiService.getUsers()
    }
}