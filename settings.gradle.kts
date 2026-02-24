rootProject.name = "reponame"

pluginManagement {
  repositories {
    maven {
      url = uri("https://repo.cosmicturnipvault.xyz/repository/maven-releases/")
      credentials {
        username = providers.gradleProperty("vanguard.nexus.username").orNull
        password = providers.gradleProperty("vanguard.nexus.password").orNull
      }
    }
    maven {
      url = uri("https://repo.cosmicturnipvault.xyz/repository/maven-snapshots/")
      credentials {
        username = providers.gradleProperty("vanguard.nexus.username").orNull
        password = providers.gradleProperty("vanguard.nexus.password").orNull
      }
    }
    gradlePluginPortal()
  }
}

sequenceOf("plugin").forEach {
  include("${rootProject.name}-$it")
  project(":${rootProject.name}-$it").projectDir = file(it)
}
