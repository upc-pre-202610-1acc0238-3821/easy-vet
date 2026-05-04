package pe.edu.upc.easyvet.di

import pe.edu.upc.easyvet.data.local.ProductDao
import pe.edu.upc.easyvet.data.repository.ProductRepositoryImpl
import pe.edu.upc.easyvet.data.remote.ProductService
import pe.edu.upc.easyvet.di.LocalModule.provideProductDao
import pe.edu.upc.easyvet.di.RemoteModule.provideProductService
import pe.edu.upc.easyvet.domain.repository.ProductRepository

object RepositoryModule {

    fun provideProductRepository(productService: ProductService = provideProductService(),
                                 productDao: ProductDao = provideProductDao()
                                 ): ProductRepository {
        return ProductRepositoryImpl(productService, productDao)
    }

}
