package com.utez.paseleguero.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class LoginViewModel : ViewModel() {

    var username = mutableStateOf("")
    var password = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var loginError = mutableStateOf("")

    fun updateUsername(value: String) {
        username.value = value
        loginError.value = ""
    }

    fun updatePassword(value: String) {
        password.value = value
        loginError.value = ""
    }

    fun login(onSuccess: () -> Unit) {
        loginError.value = ""
        isLoading.value = true

        CoroutineScope(Dispatchers.Main).launch {
            delay(1000) // simulación de carga

            if (username.value == "user" && password.value == "123") {
                isLoading.value = false
                onSuccess()
            } else {
                isLoading.value = false
                loginError.value = "Usuario o contraseña incorrectos"
            }
        }
    }

    fun clearError() {
        loginError.value = ""
    }
}
