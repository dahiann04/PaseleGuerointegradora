package com.utez.paseleguero.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utez.paseleguero.ui.model.Product
import com.utez.paseleguero.ui.repository.AuctionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: AuctionRepository) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> get() = _products

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun loadProducts() {
        viewModelScope.launch {
            try {
                _products.value = repository.getAllProducts()
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    fun createProduct(product: Product, onComplete: () -> Unit = {}) {
        viewModelScope.launch {
            try {
                repository.createProduct(product)
                loadProducts() // refrescar lista
                onComplete()
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
 
    fun updateProduct(product: Product, onComplete: () -> Unit = {}) {
        viewModelScope.launch {
            try {
                repository.updateProduct(product)
                loadProducts()
                onComplete()
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

