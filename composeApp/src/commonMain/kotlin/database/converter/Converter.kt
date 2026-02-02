package database.converter

import kotlinx.serialization.json.Json

class Converter {
    private val json = Json { ignoreUnknownKeys = true }
}