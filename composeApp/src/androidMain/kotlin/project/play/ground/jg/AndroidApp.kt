package project.play.ground.jg

import android.app.Application
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import coil3.request.crossfade
import coil3.util.DebugLogger
import com.google.firebase.Firebase
import com.google.firebase.initialize
import data.di.dataModule
import di.commonModule
import di.databaseModule
import di.provideHttpClientModule
import domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import feature.di.featureViewModel

class AndroidApp : Application(), SingletonImageLoader.Factory {
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
    
    override fun newImageLoader(context: PlatformContext): ImageLoader {
        return ImageLoader.Builder(context)
            .crossfade(true)
            .logger(DebugLogger())
            .build()
    }
}