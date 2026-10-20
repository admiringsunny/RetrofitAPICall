package com.learn.retrofitapicall.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.retrofitapicall.api.RetrofitClient
import com.learn.retrofitapicall.models.User
import com.learn.retrofitapicall.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface UserUiState {
    data object Loading : UserUiState
    data class Success(val users: List<User>) : UserUiState
    data class Error(val message: String) : UserUiState
}

class UserViewModel : ViewModel() {

    private val repository = UserRepository(RetrofitClient.apiService)
    private val _uiState = MutableStateFlow<UserUiState>(UserUiState.Loading)
    val uiState: StateFlow<UserUiState> = _uiState.asStateFlow()

    init {
        fetUsers()
    }

    private fun fetUsers() {
        viewModelScope.launch {
            _uiState.value = UserUiState.Loading
            try {
                val users = repository.getUsers()
                _uiState.value = UserUiState.Success(users)
            } catch (e: Exception) {
                _uiState.value = UserUiState.Error(
                    e.localizedMessage ?: "Unable to load Users"
                )
            }
            Log.d("TAG", "fetUsers: ${uiState}")
        }
    }
}