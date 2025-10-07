package firebase

import dev.gitlive.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow

/**
 * Fetches data **once** from Firebase Realtime Database for the given [path].
 *
 * This function:
 * - Reads the data only one time (it does NOT keep listening for changes).
 * - Returns the result as a Flow<T?> so it can be collected safely in coroutines.
 * - Works in Compose Multiplatform (Android, iOS, Desktop) using the GitLive Firebase SDK.
 *
 * Use this when:
 * - You only need the data once (for example, when opening a screen that doesn’t need live updates).
 * - You don’t want to keep a persistent listener to save battery and network resources.
 *
 * Example usage:
 * ```
 * val user = fetchOnceFromRealTimeDatabase<User>("users/$userId", database)
 *     .firstOrNull()
 * ```
 */
inline fun <reified T : Any> fetchOnceFromRealTimeDatabase(
    path: String,
    database: FirebaseDatabase
): Flow<T?> = flow {
    // Get a reference to the specific path in the database
    val reference = database.reference(path)
    // Wait for the first (and only) snapshot emitted by Firebase
    val snapshot = reference.valueEvents.firstOrNull()
    // Convert the snapshot into the desired data type (T) and emit it
    emit(snapshot?.value<T>())
}
