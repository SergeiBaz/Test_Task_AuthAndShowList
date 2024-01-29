package com.example.testtask1.app.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask1.app.model.Payment
import com.example.testtask1.app.repository.PaymentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val repository: PaymentRepository
): ViewModel(){
    private val _currentPaymentState = MutableLiveData<List<Payment>>()
    val currentPaymentState: LiveData<List<Payment>> = _currentPaymentState

    fun getListPayments() {
        viewModelScope.launch {
            val listPayments = repository.getListPayments()
            withContext(Dispatchers.Main) {
                _currentPaymentState.value = listPayments
            }
        }
    }
}