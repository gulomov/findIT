package di

import data.di.dataModule
import domain.di.domainModule
import org.koin.core.context.startKoin
import ui.di.featureViewModel

fun initKoin() {
    startKoin {
        modules(
            databaseModule,
            commonModule,
            provideHttpClientModule,
            domainModule,
            dataModule,
            featureViewModel,
        )
    }
}
