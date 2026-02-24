import xyz.jpenilla.resourcefactory.paper.PaperPluginYaml
import xyz.jpenilla.resourcefactory.paper.paperPluginYaml

plugins {
  id("com.vanguard.common-conventions") version ("1.0.0")
  //id("com.vanguard.publish-conventions") version ("1.0.0") // Uncomment this line if you want to publish this plugin to a maven repository
}

dependencies {
  //compileOnly(fileTree(mapOf("dir" to "../libs", "include" to listOf("*.jar")))) // Uncomment this line if you want to use .jar libs
  //compileOnly("com.vanguard:essentials-api:1.0.0") // Uncomment this line if you want to add essentials as dependency (change version)
  //api(libs.core)
//annotationProcessor(libs.core)
}

vanguard {
 paper(version = libs.versions.paper.get(), paperweightEnabled = true)
}

paperPluginYaml {
  name = "Vanguardreponame"
  main = "com.vanguard.reponamelower.reponamePlugin"
  apiVersion = "1.21.4"
  authors.add("VanguardFactions")
  description = "Example description."
  dependencies {
    server("VanguardCore", PaperPluginYaml.Load.BEFORE, true, joinClasspath = true)
    //server("VanguardEssentials", PaperPluginYaml.Load.BEFORE, true, joinClasspath = true) // Uncomment this line if you want to add essentials as dependency
  }
}
