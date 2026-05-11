package pe.edu.upc.easyvet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import pe.edu.upc.easyvet.data.remote.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Named("url")
    fun provideBaseUrl(): String {
        return "https://petapi-591531460223.us-central1.run.app/api/"
    }

    @Provides
    @Singleton
    fun provideRetrofit(@Named("url") url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Provides
    @Singleton
    fun provideProductService(retrofit: Retrofit): ProductService {
        return retrofit.create(ProductService::class.java)
    }

}