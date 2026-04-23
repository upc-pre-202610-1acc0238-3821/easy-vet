package pe.edu.upc.easyvet.presentation

import pe.edu.upc.easyvet.domain.Product

data class UiState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
