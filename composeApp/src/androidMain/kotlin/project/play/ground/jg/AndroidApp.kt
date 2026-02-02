package project.play.ground.jg

import android.app.Application
import com.google.firebase.Firebase
import com.google.firebase.initialize
import data.di.dataModule
import di.commonModule
import di.databaseModule
import di.provideHttpClientModule
import domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ui.di.featureViewModel

class AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(this)
        
        startKoin {
            androidContext(this@AndroidApp)
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
}