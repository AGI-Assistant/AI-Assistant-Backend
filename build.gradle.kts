plugins {
    java
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-resteasy-reactive")
    implementation("io.quarkus:quarkus-jackson")
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
    implementation("io.quarkus:quarkus-agroal:3.2.0.Final")
// https://mvnrepository.com/artifact/io.quarkus/quarkus-hibernate-orm-panache
    implementation("io.quarkus:quarkus-hibernate-orm-panache:3.2.0.Final")
// https://mvnrepository.com/artifact/io.quarkus/quarkus-jdbc-postgresql
    implementation("io.quarkus:quarkus-jdbc-postgresql:3.2.0.Final")
    implementation("io.quarkus:quarkus-narayana-jta")
    testImplementation("io.rest-assured:rest-assured")
    //Test Dependencies
    testImplementation("org.testcontainers:postgresql:1.6.0")
    testImplementation("io.quarkus:quarkus-junit5")

}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
