package com.utez.paseleguero.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.utez.paseleguero.ui.viewmodel.AuctionDetailViewModel
import java.text.NumberFormat
import java.util.*
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuctionDetailScreen(
    viewModel: AuctionDetailViewModel,
    onNavigateBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val state = uiState ?: return
    val product = state.product
    val formatter = NumberFormat.getCurrencyInstance(Locale("es", "MX"))
    val formattedPrice = formatter.format(product.currentPrice)
    var bidInput by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(product.title.ifBlank { "Detalle de subasta" }, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        }
    ) { padding ->
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
            return@Scaffold
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AsyncImage(
                model = product.imageUrl.ifBlank { null },
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = product.title.ifBlank { "Sin título" },
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Precio actual: $formattedPrice",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "Descripción: ${product.description}",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Pujas: ${product.bidsCount}",
                style = MaterialTheme.typography.bodySmall
            )

