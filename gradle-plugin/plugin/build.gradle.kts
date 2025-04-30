val developerId: String by project
val releaseArtifact: String by project
val releaseGroup: String by project
val releaseDescription: String by project
val releaseUrl: String by project

val jdkVersion = JavaLanguageVersion.of(libs.versions.jdk.get())
val jreVersion = JavaLanguageVersion.of(libs.versions.jre.get())

plugins {
    groovy
    codenarc
    alias(libs.plugins.gradle.publish)
}

java.toolchain.languageVersion.set(jdkVersion)

codenarc.toolVersion = libs.versions.codenarc.get()

gradlePlugin {
    website.set(releaseUrl)
    vcsUrl.set("https://github.com/$developerId/$releaseArtifact.git")
    plugins.register("myPlugin") {
        id = "$releaseGroup.$releaseArtifact"
        implementationClass = "$releaseGroup.$releaseArtifact.MyPlugin"
        displayName = "My Plugin"
        description = releaseDescription
        tags.set(listOf("first-tag", "second-tag"))
    }
    testSourceSets(sourceSets.test.get())
}

dependencies {
    codenarc(libs.rulebook.codenarc)

    compileOnly(gradleApi())

    implementation(libs.groovy.all)

    testImplementation(gradleTestKit())
    testImplementation(libs.truth)
}

tasks {
    compileJava {
        options.release = jreVersion.asInt()
    }
    compileGroovy {
        options.release = jreVersion.asInt()
    }
    groovydoc {
        destinationDir = layout.buildDirectory.dir("docs/${project.name}").get().asFile
    }
}
