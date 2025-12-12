package com.utez.paseleguero.ui.model

data class Product(
    val id: String,
    val title: String,
    val description: String,
    val startingPrice: Double,
    val currentPrice: Double,
    val endTime: Long,
    val ownerId: String,
    val ownerName: String,
    val status: String,
    val imageUrl: String,
    val bidsCount: Int,
    val createdAt: Long
)
