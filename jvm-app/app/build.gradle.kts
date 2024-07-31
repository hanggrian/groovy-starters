val releaseGroup: String by project

plugins {
    groovy
    application
    codenarc
    jacoco
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(libs.versions.jdk.get()))

application.mainClass.set("$releaseGroup.app.App")

codenarc.toolVersion = libs.versions.codenarc.get()

dependencies {
    codenarc(libs.rulebook.codenarc)

    implementation(libs.groovy)

    testImplementation(libs.truth)
}
