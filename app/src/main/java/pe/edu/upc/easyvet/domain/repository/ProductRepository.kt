package pe.edu.upc.easyvet.domain.repository

import pe.edu.upc.easyvet.domain.model.Product

interface ProductRepository {

    suspend fun getProducts(): List<Product>
}