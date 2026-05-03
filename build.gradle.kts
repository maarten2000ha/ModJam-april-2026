plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.0"
}

group = "com.example.modjamapril2026"
version = "0.0.1"

repositories {
    mavenCentral()
    // Official Hytale Maven repository
    maven {
        name = "hytale-release"
        url = uri("https://maven.hytale.com/release")
    }
//    maven {
//        name = "hytale-pre-release"
//        url = uri("https://maven.hytale.com/pre-release")
//    }
}

dependencies {
    // Hytale Server API from official Maven repository
    // + notes the latest compatible version
    compileOnly("com.hypixel.hytale:Server:+")
    // JSR305 annotations (@Nonnull, @Nullable)
    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.google.code.gson:gson:2.10.1")
//    runtimeOnly("dev.scaffoldit:devtools:0.2.+")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

tasks.shadowJar {
    archiveClassifier.set("")
    // Exclude server classes from the final JAR
    dependencies {
        exclude(dependency("com.hypixel:.*:.*"))
    }
}

// Disable the default jar task to avoid conflicts with shadowJar
tasks.named("jar") {
    enabled = false
}

tasks.named("build") {
    dependsOn(tasks.shadowJar)
}

// Deploy plugin JAR to server mods folder
tasks.register<Copy>("deployToServer") {
    // Using 'from shadowJar' automatically adds task dependency and proper input tracking
    from(tasks.shadowJar)
    into("server/mods")
    doLast {
        println("Deployed to server/mods/")
    }
}

// Watch for changes and auto-rebuild (useful during development)
tasks.register("watch") {
    doLast {
        println("Watching for changes... Press Ctrl+C to stop.")
        println("Run 'gradle build --continuous' for auto-rebuild on file changes.")
    }
}