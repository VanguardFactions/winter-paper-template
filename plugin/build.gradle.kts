import xyz.jpenilla.resourcefactory.paper.PaperPluginYaml

plugins {
  id("vanguard.common-conventions")
  id("com.github.johnrengelman.shadow") version ("8.1.1")
  id("xyz.jpenilla.resource-factory-paper-convention") version ("1.2.0")
}

repositories {
  maven("https://repo.papermc.io/repository/maven-public/")
  maven("https://jitpack.io")
  mavenLocal()
}

paperPluginYaml {
  name = "ExamplePlugin"
  main = "net.vanguard.example.Example"
  apiVersion = "1.21.4"
  authors.add("VanguardFactions")
  description = "A plugin that adds spawners to the game."
  dependencies {
    server("VanguardCore", PaperPluginYaml.Load.BEFORE, true, joinClasspath = true)
  }
}

dependencies {
  compileOnlyApi(libs.paper)
  compileOnlyApi(libs.core)
  annotationProcessor(libs.core)
}
