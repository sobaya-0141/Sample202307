package sobaya.app.repository

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform