package project.play.ground.jg

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform