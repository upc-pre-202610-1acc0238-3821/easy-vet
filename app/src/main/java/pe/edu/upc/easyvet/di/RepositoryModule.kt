package pe.edu.upc.easyvet.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pe.edu.upc.easyvet.data.local.ProductDao
import pe.edu.upc.easyvet.data.repository.ProductRepositoryImpl
import pe.edu.upc.easyvet.data.remote.ProductService
import pe.edu.upc.easyvet.di.LocalModule.provideProductDao
import pe.edu.upc.easyvet.di.RemoteModule.provideProductService
import pe.edu.upc.easyvet.domain.repository.ProductRepository

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun provideProductRepository(
        impl: ProductRepositoryImpl
    ): ProductRepository

}
