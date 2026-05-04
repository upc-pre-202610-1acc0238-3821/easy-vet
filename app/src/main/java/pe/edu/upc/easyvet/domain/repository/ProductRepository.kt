package pe.edu.upc.easyvet.domain.repository

import kotlinx.coroutines.flow.Flow
import pe.edu.upc.easyvet.domain.model.Product

interface ProductRepository {

    suspend fun getProducts(): Flow<List<Product>>
    suspend fun syncProducts()
}