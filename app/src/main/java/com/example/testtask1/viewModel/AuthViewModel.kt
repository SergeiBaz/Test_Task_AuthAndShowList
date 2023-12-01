package com.example.testtask1.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask1.model.Token
import com.example.testtask1.model.User
import com.example.testtask1.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel(){
    private val _currentTokenState = MutableLiveData<Token?>()
    val currentTokenState: LiveData<Token?> = _currentTokenState

    fun logInUser(user: User) {
        viewModelScope.launch {
            val userLog = repository.logInUser(user)
            val token = repository.logInUser(user)
            Log.d("log", "${token?._token}")
            withContext(Dispatchers.Main){
                _currentTokenState.value = token
            }
        }
    }
}