package worker

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.work.WorkerParameters
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import domain.feature.recommendations.RecommendationsRepository
import domain.feature.recommendations.model.Recommendation
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.UUID

class NotificationWorker(context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters), KoinComponent {

    private val recommendationsRepository: RecommendationsRepository by inject()

    override suspend fun doWork(): Result {
        try {
            val brandName = "${UUID.randomUUID().mostSignificantBits}"
            val recommendation = Recommendation(
                id = UUID.randomUUID().variant(),
                image = "https://picsum.photos/200/300",
                brand = brandName,
            )

            recommendationsRepository.saveRecommendation(recommendation = recommendation)

            showNotification(brandName)
            return Result.success()
        } catch (e: Exception) {
            return Result.failure()
        }
    }

    private fun showNotification(brandName: String) {
        val chanelId = "chanel1"
        val notificationManager: NotificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(
                chanelId,
                "Periodic Notification",
                importance
            )
            channel.description = "Periodic Notification"
            notificationManager.createNotificationChannel(channel)
        }

        val notification: Notification = NotificationCompat.Builder(applicationContext, chanelId)
            .setContentTitle("Notification")
            .setContentText(brandName)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .build()

        notificationManager.notify(1, notification)
    }
}