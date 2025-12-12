package com.utez.paseleguero.ui.repository

import com.utez.paseleguero.ui.model.Bid
import com.utez.paseleguero.ui.model.Product
import com.utez.paseleguero.ui.network.ApiConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuctionRepository {

    private val api = ApiConfig.apiService
}
suspend fun getAllProducts(): List<Product> = withContext(Dispatchers.IO) {
    api.getProducts().data ?: emptyList()
}
suspend fun createProduct(product: Product): Product? = withContext(Dispatchers.IO) {
    api.createProduct(product).data
}
suspend fun updateProduct(product: Product): Product? = withContext(Dispatchers.IO) {
    api.updateProduct(product.id, product).data
}
