package com.utez.paseleguero.ui.model

data class Bid(
    val id: String,
    val productId: String,
    val userId: String,
    val amount: Double,
    val timestamp: Long
)
