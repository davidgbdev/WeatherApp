import java.util.Properties

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

// Gradle downloads token for Mapbox. Value lives in the untracked secrets.properties.
val mapboxDownloadsToken = Properties().apply {
    val secretsFile = file("secrets.properties")
    if (secretsFile.exists()) {
        secretsFile.inputStream().use { load(it) }
    }
}.getProperty("MAPBOX_DOWNLOADS_TOKEN")?.trim().orEmpty()
extra["MAPBOX_DOWNLOADS_TOKEN"] = mapboxDownloadsToken

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "WeatherApp"
include(":app")
include(":data")
include(":localDataSource")
include(":remoteDataSource")
include(":domain")
