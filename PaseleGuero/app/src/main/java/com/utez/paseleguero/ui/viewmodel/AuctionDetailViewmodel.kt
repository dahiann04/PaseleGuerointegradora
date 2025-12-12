package com.utez.paseleguero.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utez.paseleguero.ui.model.Bid
import com.utez.paseleguero.ui.model.Product
import com.utez.paseleguero.ui.network.ApiConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class AuctionDetailUiState(
    val product: Product,
    val isLoading: Boolean = false,
    val error: String? = null
)
class AuctionDetailViewModel(private val productId: String) : ViewModel() {

    private val _uiState = MutableStateFlow<AuctionDetailUiState?>(null)
    val uiState: StateFlow<AuctionDetailUiState?> = _uiState

    init { loadProduct() }
