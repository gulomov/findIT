package database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import database.dao.ProductsDao
import database.entity.RecommendationEntity

@Database(
    entities = [RecommendationEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase(){
    abstract fun productsDao(): ProductsDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor: RoomDatabaseConstructor<AppDatabase>{
    override fun initialize(): AppDatabase
}
