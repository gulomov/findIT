package project.play.ground.jg

import App
import android.Manifest
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import worker.  NotificationWorker
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {

    /*private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                scheduleNotification(this)
            } else {
                // Permission denied
            }

        }*/

    /*private fun scheduleNotification(context: Context) {
        val periodNotificationRequest: PeriodicWorkRequest =
            PeriodicWorkRequestBuilder<NotificationWorker>(
                repeatInterval = 15,
                repeatIntervalTimeUnit = TimeUnit.MINUTES
            ).build()
//        WorkManager.getInstance(context).enqueue(periodNotificationRequest)
        // Difference is if I will call enqueue twice two of notifications will show
        WorkManager.getInstance(context)
            .enqueueUniquePeriodicWork(
                "HourlyNotification",
                ExistingPeriodicWorkPolicy.UPDATE,
                periodNotificationRequest
            )
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
          /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            } else {
                scheduleNotification(this)
            }*/
            App()
        }
    }
}
