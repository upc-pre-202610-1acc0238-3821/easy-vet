package pe.edu.upc.easyvet.di

import androidx.room.Room
import pe.edu.upc.easyvet.MyApplication
import pe.edu.upc.easyvet.data.local.AppDatabase
import pe.edu.upc.easyvet.data.local.ProductDao

object LocalModule {

    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(
            MyApplication.instance.applicationContext,
            AppDatabase::class.java,
            "easyvet-db"
        ).build()
    }

    fun provideProductDao(database: AppDatabase = provideDatabase()): ProductDao {
        return database.productDao()
    }
}