val releaseArtifact: String by project

plugins {
    groovy
    codenarc
    application
}

application.mainClass.set("com.example.App")

dependencies {
    codenarc(libs.rulebook.codenarc)
    
    implementation(project(":$releaseArtifact"))
    implementation(project(":$releaseArtifact-extension"))
    implementation(libs.groovy.all)
}
