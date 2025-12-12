package com.utez.paseleguero.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utez.paseleguero.ui.model.Bid
import com.utez.paseleguero.ui.repository.AuctionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BidViewModel(private val repository: AuctionRepository) : ViewModel() {

    private val _bids = MutableStateFlow<List<Bid>>(emptyList())
    val bids: StateFlow<List<Bid>> get() = _bids

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun loadBids(productId: String) {
        viewModelScope.launch {
            try {
                _bids.value = repository.getBidsForProduct(productId)
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
    // Hacer una oferta
    fun placeBid(bid: Bid, onComplete: () -> Unit = {}) {
        viewModelScope.launch {
            try {
                repository.placeBid(bid)
                loadBids(bid.productId)
                onComplete()
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

