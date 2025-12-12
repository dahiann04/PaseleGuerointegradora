package com.utez.paseleguero.ui.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utez.paseleguero.ui.model.Product
import com.utez.paseleguero.ui.network.ApiConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.File
import java.util.*

data class CreateAuctionUiState(
    val title: String = "",
    val description: String = "",
    val startingPrice: String = "",
    val durationHours: String = "",
    val imageUri: Uri? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

class CreateAuctionViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CreateAuctionUiState())
    val uiState: StateFlow<CreateAuctionUiState> = _uiState
    fun updateTitle(value: String) {
        _uiState.value = _uiState.value.copy(title = value)
    }

    fun updateDescription(value: String) {
        _uiState.value = _uiState.value.copy(description = value)
    }

    fun updateStartingPrice(value: String) {
        _uiState.value = _uiState.value.copy(startingPrice = value)
    }
