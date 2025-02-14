plugins {
  id("vanguard.common-conventions")
  id("com.github.johnrengelman.shadow") version ("8.1.1")
}

repositories {
  maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
  compileOnlyApi(libs.paper)
}
