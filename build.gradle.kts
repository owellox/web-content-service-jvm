plugins {
    application
    kotlin("jvm") version "1.5.30"
}

group = "com.owellox.jvm.services"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("com.owellox.jvm.services.WebContentServiceKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:1.6.3")
    implementation("io.ktor:ktor-server-netty:1.6.3")
    implementation("ch.qos.logback:logback-classic:1.2.5")
    implementation(project(":ktor-spa"))
}