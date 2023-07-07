package sobaya.app.repository

import kotlinx.coroutines.delay

class Sample {
    suspend fun sample(): String {
        delay(500)
        return "SAMPLE"
    }
}