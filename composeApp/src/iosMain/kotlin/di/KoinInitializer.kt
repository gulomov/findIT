package di

import data.di.dataModule
import domain.di.domainModule
import org.koin.core.context.startKoin
import feature.di.featureViewModel

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
