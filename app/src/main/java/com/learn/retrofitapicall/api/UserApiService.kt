package com.learn.retrofitapicall.api

import com.learn.retrofitapicall.models.User
import retrofit2.http.GET

interface UserApiService {
    @GET("/users")
    suspend fun getUsers(): List<User>
}