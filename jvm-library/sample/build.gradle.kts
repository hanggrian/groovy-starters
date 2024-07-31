val releaseArtifact: String by project

plugins {
    groovy
    application
}

application.mainClass.set("com.example.App")

dependencies {
    implementation(libs.groovy)
    implementation(project(":$releaseArtifact"))
    implementation(project(":$releaseArtifact-extension"))
}
