val releaseArtifact: String by project

plugins {
    groovy
    codenarc
    jacoco
    alias(libs.plugins.maven.publish)
}

dependencies {
    codenarc(libs.rulebook.codenarc)

    implementation(project(":$releaseArtifact"))
    implementation(libs.groovy)

    testImplementation(libs.truth)
}
