package com.utez.paseleguero.ui.network

import com.utez.paseleguero.ui.model.Bid
import com.utez.paseleguero.ui.model.Product
import retrofit2.http.*

interface ApiService {

    // 🔥 Flask devuelve: { success: true, data: [...] }
    @GET("products")
    suspend fun getProducts(): ApiResponse<List<Product>>

    // 🔥 También devuelve: { success: true, data: {...} }
    @POST("products")
    suspend fun createProduct(@Body product: Product): ApiResponse<Product>

    @PUT("products/{id}")
    suspend fun updateProduct(
        @Path("id") id: String,
        @Body product: Product
    ): ApiResponse<Product>

    @DELETE("products/{id}")
    suspend fun deleteProduct(
        @Path("id") id: String
    ): ApiResponse<Unit>
    LaunchedEffect(captureTrigger) {
        if (captureTrigger) {
            val file = createImageFile()
            val outputOptions = ImageCapture.OutputFileOptions.Builder(file).build()
            imageCapture?.takePicture(
                outputOptions,
                cameraExecutor,
                object : ImageCapture.OnImageSavedCallback {
                    override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                        onImageCaptured(Uri.fromFile(file), file)
                        onCapturedConsumed()
                    }

                    override fun onError(exception: ImageCaptureException) {
                        onError(exception)
                        onCapturedConsumed()
                    }
                }
            )
        }
    }
