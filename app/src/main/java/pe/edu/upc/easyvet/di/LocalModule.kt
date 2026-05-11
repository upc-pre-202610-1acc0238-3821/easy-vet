package pe.edu.upc.easyvet.di

import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import pe.edu.upc.easyvet.MyApplication
import pe.edu.upc.easyvet.data.local.AppDatabase
import pe.edu.upc.easyvet.data.local.ProductDao

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(
            MyApplication.instance.applicationContext,
            AppDatabase::class.java,
            "easyvet-db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductDao(database: AppDatabase ): ProductDao {
        return database.productDao()
    }
}