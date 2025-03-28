import org.codehaus.plexus.util.StringUtils
import xyz.jpenilla.resourcefactory.paper.PaperPluginYaml

plugins {
  `maven-publish`
  id("vanguard.common-conventions")
  id("com.github.johnrengelman.shadow") version ("8.1.1")
  id("xyz.jpenilla.resource-factory-paper-convention") version ("1.2.0")
  //id("io.papermc.paperweight.userdev") version "2.0.0-beta.16" // Uncomment this line if you want to use Paperweight
}

repositories {
  maven("https://repo.papermc.io/repository/maven-public/")
  maven("https://jitpack.io")
  mavenLocal()
  mavenCentral()
}

paperPluginYaml {
  name = "reponame"
  main = "com.vanguardfactions.reponamelower.reponamePlugin"
  apiVersion = "1.21.4"
  authors.add("VanguardFactions")
  description = "Example description."
  dependencies {
    server("VanguardCore", PaperPluginYaml.Load.BEFORE, true, joinClasspath = true)
    //server("VanguardEssentials", PaperPluginYaml.Load.BEFORE, true, joinClasspath = true) // Uncomment this line if you want to add essentials as dependency
  }
}

dependencies {
  //paperweight.paperDevBundle("1.21.4-R0.1-SNAPSHOT") // Uncomment this line if you want to use Paperweight
  //compileOnly(fileTree(mapOf("dir" to "../libs", "include" to listOf("*.jar")))) // Uncomment this line if you want to use .jar libs
  //compileOnly("com.vanguardfactions:essentials-plugin:0.0.1") // Uncomment this line if you want to add essentials as dependency (change version)
  compileOnlyApi(libs.paper)
  compileOnlyApi(libs.core)
  annotationProcessor(libs.core)
}

tasks {
  shadowJar {
    val projectName = StringUtils.capitalise(project.name)
    archiveFileName.set("Vanguard${projectName}-${project.version}.jar")
  }
/*
  reobfJar {
    outputJar = layout.buildDirectory.file("libs/Vanguard${projectName}-${project.version}-reobfJar.jar")
  }
 */
}


