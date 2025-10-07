package project.play.ground.jg

import android.app.Application
import data.di.dataModule
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.initialize
import di.firebaseModule
import di.provideHttpClientModule
import domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(this)
        startKoin {
            androidContext(this@AndroidApp)
            androidLogger()
            modules(
                firebaseModule,
                provideHttpClientModule,
                domainModule,
                dataModule,
            )
        }
    }
}