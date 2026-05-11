package pe.edu.upc.easyvet.data.repository

import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import pe.edu.upc.easyvet.data.local.ProductDao
import pe.edu.upc.easyvet.data.mapper.toDomain
import pe.edu.upc.easyvet.data.mapper.toEntity
import pe.edu.upc.easyvet.data.remote.ProductService
import pe.edu.upc.easyvet.domain.model.Product
import pe.edu.upc.easyvet.domain.repository.ProductRepository

class ProductRepositoryImpl @Inject constructor(
    val productService: ProductService,
    val productDao: ProductDao
) : ProductRepository {

    override suspend fun getProducts(): Flow<List<Product>> = withContext(Dispatchers.IO) {
        return@withContext productDao.getProducts()
            .map { entities ->
                entities.map { productEntity ->
                    productEntity.toDomain()
                }
            }
    }

    override suspend fun syncProducts() {
        val response = productService.getProducts()

        if (response.isSuccessful) {
            response.body()?.let { productsDto ->
                val entities = productsDto.products.map { productDto ->
                    productDto.toEntity()
                }
                productDao.deleteAllProducts()
                productDao.insertProducts(entities)
            }
        }
    }

}