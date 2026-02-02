package project.play.ground.jg.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.AppDatabase
import kotlinx.coroutines.Dispatchers

internal fun getAppDatabase(context: Context): AppDatabase {
    val dbFile = context.getDatabasePath("find-it.db")
    return Room.databaseBuilder<AppDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .fallbackToDestructiveMigration(true).build()
}