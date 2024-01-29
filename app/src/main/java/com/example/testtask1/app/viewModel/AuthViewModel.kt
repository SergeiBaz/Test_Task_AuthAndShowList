package com.example.testtask1.app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask1.app.model.User
import com.example.testtask1.app.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    private val _currentTokenState = MutableLiveData<String?>()
    val currentTokenState: LiveData<String?> = _currentTokenState

    private val _currentResponseState = MutableLiveData<Boolean>()
    val currentResponseState: LiveData<Boolean> = _currentResponseState

    private val _currentResponseErrorState = MutableLiveData<String>()
    val currentResponseErrorState: LiveData<String> = _currentResponseErrorState

    fun logInUser(user: User) {
        viewModelScope.launch {
            val response = repository.logInUser(user)
            withContext(Dispatchers.Main) {
                _currentTokenState.value = response?._response?._token
                _currentResponseErrorState.value = response?._error?._errorMsg
                _currentResponseState.value = response?._success
            }
        }
    }
}