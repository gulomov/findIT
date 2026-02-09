import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.database.database
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

suspend fun <T> listenToList(
    path: String,
    arrayKey: String,
    deserializer: KSerializer<T>
): List<T> {
    val ref = Firebase.database.reference(path)
    val snapshot = ref.valueEvents.first()
    val rawList = snapshot.child(arrayKey).value
    return if (rawList is List<*>) {
        rawList.mapNotNull { item ->
            (item as? Map<*, *>)?.let { map ->
                val jsonObj = map.mapNotNull { (k, v) ->
                    (k as? String)?.let { key -> key to JsonPrimitive(v?.toString() ?: "") }
                }.toMap()
                val jsonString = Json.encodeToString(JsonObject.serializer(), JsonObject(jsonObj))
                try {
                    Json.decodeFromString(deserializer, jsonString)
                } catch (e: Exception) {
                    null
                }
            }
        }
    } else emptyList()
}
suspend inline fun <reified T> listenToObject(path: String): Flow<T?> {
    val ref = Firebase.database.reference(path)
    return ref.valueEvents.map { snapshot ->
        snapshot.value<T>()
    }
}