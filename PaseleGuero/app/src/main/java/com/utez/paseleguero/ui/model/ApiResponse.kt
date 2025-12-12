package com.utez.paseleguero.ui.network

data class ApiResponse<T>(
    val data: T,
    val success: Boolean
)
