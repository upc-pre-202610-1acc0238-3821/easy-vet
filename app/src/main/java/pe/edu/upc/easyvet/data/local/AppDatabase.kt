package pe.edu.upc.easyvet.data.local

import androidx.room.Database

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase {
    abstract fun productDao(): ProductDao
}