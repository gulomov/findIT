package project.play.ground.jg

import android.app.Application
import data.di.dataModule
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.initialize
import di.firebaseModule
import di.provideHttpClientModule
import domain.di.domainModule
import org.koin.compose.KoinApplication
import org.koin.core.KoinApplication
import ui.di.featureViewModel

class AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(this)
    }
}