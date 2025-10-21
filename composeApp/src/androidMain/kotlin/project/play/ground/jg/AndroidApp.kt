package project.play.ground.jg

import android.app.Application
import com.google.firebase.Firebase
import com.google.firebase.initialize

class AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(this)
    }
}