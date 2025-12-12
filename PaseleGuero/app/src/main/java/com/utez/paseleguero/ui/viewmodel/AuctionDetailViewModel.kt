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

    private fun emptyProduct() = Product(
        id = "",
        title = "",
        description = "",
        startingPrice = 0.0,
        currentPrice = 0.0,
        endTime = 0L,
        ownerId = "",
        ownerName = "",
        status = "",
        imageUrl = "",
        bidsCount = 0,
        createdAt = 0L
    )
    fun loadProduct() {
        viewModelScope.launch {
            try {
                val response = ApiConfig.apiService.getProducts()
                val product = response.data.firstOrNull { it.id == productId }
                _uiState.value = if (product != null) {
                    AuctionDetailUiState(product)
                } else {
                    AuctionDetailUiState(emptyProduct(), error = "Producto no encontrado")
                }
            } catch (e: Exception) {
                _uiState.value = AuctionDetailUiState(emptyProduct(), error = e.localizedMessage ?: "Error desconocido")
            }
        }
    }
    fun placeBid(amount: Double) {
        val state = _uiState.value ?: return
        val product = state.product

        viewModelScope.launch {
            _uiState.value = state.copy(isLoading = true)
            try {
                val bid = Bid(
                    id = "",
                    productId = product.id,
                    userId = "123",
                    amount = amount,
                    timestamp = System.currentTimeMillis()
                )
                val apiResponse = ApiConfig.apiService.placeBid(product.id, bid)

                if (apiResponse.success) {
                    val updated = product.copy(
                        currentPrice = amount,
                        bidsCount = product.bidsCount + 1
                    )
                    _uiState.value = AuctionDetailUiState(updated)
                } else {
                    _uiState.value = state.copy(isLoading = false, error = "Error al ofertar")
                }
            } catch (e: Exception) {
                _uiState.value = state.copy(isLoading = false, error = e.localizedMessage ?: "Error desconocido")
            }
        }
    }
    fun deleteAuction(onDeleted: () -> Unit) {
        val state = _uiState.value ?: return
        viewModelScope.launch {
            _uiState.value = state.copy(isLoading = true)
            try {
                val apiResponse = ApiConfig.apiService.deleteProduct(state.product.id)
                if (apiResponse.success) onDeleted()
                else _uiState.value = state.copy(isLoading = false, error = "Error al eliminar")
            } catch (e: Exception) {
                _uiState.value = state.copy(isLoading = false, error = e.localizedMessage ?: "Error desconocido")
            }
        }
    }
