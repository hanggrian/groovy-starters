plugins {
    groovy
    codenarc
    jacoco
    alias(libs.plugins.maven.publish)
}

dependencies {
    codenarc(libs.rulebook.codenarc)

    implementation(libs.groovy)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.junit5)

    testRuntimeOnly(libs.junit.platform.launcher)
}
