val releaseGroup: String by project
val releaseVersion: String by project
val releaseArtifact: String by project

val javaCompileVersion = JavaLanguageVersion.of(libs.versions.java.compile.get())
val javaSupportVersion = JavaVersion.toVersion(libs.versions.java.support.get())

allprojects {
    group = releaseGroup
    version = releaseVersion
}

plugins {
    groovy
    application
    codenarc
    jacoco
}

java {
    toolchain.languageVersion.set(javaCompileVersion)
    sourceCompatibility = javaSupportVersion
    targetCompatibility = javaSupportVersion
}

application.mainClass.set("$releaseGroup.$releaseArtifact.App")

codenarc.toolVersion = libs.versions.codenarc.get()

dependencies {
    codenarc(libs.rulebook.codenarc)

    implementation(libs.groovy.all)
    implementation(libs.dagger)

    annotationProcessor(libs.dagger.compiler)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.junit5)

    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks {
    test {
        useJUnitPlatform()
    }
    jacocoTestReport {
        reports.xml.required = true
    }
}
