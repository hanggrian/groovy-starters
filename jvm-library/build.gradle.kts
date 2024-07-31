val developerId: String by project
val developerName: String by project
val developerUrl: String by project
val releaseGroup: String by project
val releaseArtifact: String by project
val releaseVersion: String by project
val releaseDescription: String by project
val releaseUrl: String by project

plugins {
    alias(libs.plugins.maven.publish) apply false
}

allprojects {
    group = releaseGroup
    version = releaseVersion
}

subprojects {
    plugins.withType<JavaPlugin>().configureEach {
        the<JavaPluginExtension>().toolchain.languageVersion
            .set(JavaLanguageVersion.of(libs.versions.jdk.get().toInt()))
    }
    plugins.withType<CodeNarcPlugin>().configureEach {
        the<CodeNarcExtension>().toolVersion = libs.versions.codenarc.get()
    }
    plugins.withType<com.vanniktech.maven.publish.MavenPublishBasePlugin> {
        configure<com.vanniktech.maven.publish.MavenPublishBaseExtension> {
            configure(
                com.vanniktech.maven.publish.JavaLibrary(
                    com.vanniktech.maven.publish.JavadocJar.Javadoc()
                )
            )
            publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.CENTRAL_PORTAL)
            signAllPublications()
            pom {
                name.set(project.name)
                description.set(releaseDescription)
                url.set(releaseUrl)
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set(developerId)
                        name.set(developerName)
                        url.set(developerUrl)
                    }
                }
                scm {
                    url.set(releaseUrl)
                    connection.set("scm:git:https://github.com/$developerId/$releaseArtifact.git")
                    developerConnection.set("scm:git:ssh://git@github.com/$developerId/$releaseArtifact.git")
                }
            }
        }
    }
}

tasks.register(LifecycleBasePlugin.CLEAN_TASK_NAME) {
    delete(layout.buildDirectory)
}
