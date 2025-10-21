package di

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import co.touchlab.kermit.StaticConfig
import co.touchlab.kermit.platformLogWriter
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.database.database
import org.koin.dsl.module

val commonModule = module {
    single {
        Logger(
            config = StaticConfig(
                minSeverity = Severity.Debug,
                logWriterList = listOf(platformLogWriter())
            ),
            "FindIT"
        )
    }

    single {
        Firebase.database("https://findit-f0273-default-rtdb.europe-west1.firebasedatabase.app")
    }
}