val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.7.20"
    id("io.ktor.plugin") version "2.1.2"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.20"
    id("com.github.node-gradle.node") version "3.4.0"

}

group = "devrel.adyen.nl"
version = "0.0.1"
application {
    mainClass.set("nl.adyen.devrel.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-host-common-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-status-pages-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-metrics-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("com.adyen:adyen-java-api-library:18.1.2")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

val installWebDependencies by tasks.registering(com.github.gradle.node.npm.task.NpmTask::class){
    workingDir.set(File("./src/main/js/pluckr-app"))
    args.set(listOf("install"))
}

val buildWebDependencies by tasks.registering(com.github.gradle.node.npm.task.NpmTask::class){
    dependsOn(installWebDependencies)
    workingDir.set(File("./src/main/js"))
    args.set(listOf("run", "dist"))
}

tasks.build {
    dependsOn(buildWebDependencies)
}