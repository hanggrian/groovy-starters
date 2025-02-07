val releaseGroup: String by project
val releaseArtifact: String by project

val jdkVersion = JavaLanguageVersion.of(libs.versions.jdk.get())
val jreVersion = JavaLanguageVersion.of(libs.versions.jre.get())

plugins {
    groovy
    application
    codenarc
    jacoco
}

java.toolchain.languageVersion.set(jdkVersion)

application.mainClass.set("$releaseGroup.$releaseArtifact.App")

codenarc.toolVersion = libs.versions.codenarc.get()

dependencies {
    codenarc(libs.rulebook.codenarc)

    implementation(libs.groovy)

    testImplementation(libs.truth)
}

tasks {
    compileJava {
        options.release = jreVersion.asInt()
    }
    compileGroovy {
        options.release = jreVersion.asInt()
    }
    jacocoTestReport {
        reports.xml.required = true
    }
}
