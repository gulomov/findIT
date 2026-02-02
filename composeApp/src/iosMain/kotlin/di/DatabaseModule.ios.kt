package di

import database.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import project.play.ground.jg.database.getAppDatabase

actual val databaseModule = module {
    single<AppDatabase> {
        getAppDatabase()
    }
}