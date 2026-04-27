package pe.edu.upc.easyvet.presentation.home

import pe.edu.upc.easyvet.domain.model.Product

data class UiState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)