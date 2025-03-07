plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // https://mvnrepository.com/artifact/org.finos.legend.engine/legend-engine-xt-relationalStore-postgresSql-protocol
    implementation("org.finos.legend.engine:legend-engine-xt-relationalStore-postgresSql-protocol:4.71.1")

    // https://mvnrepository.com/artifact/org.scala-lang/scala3-library
    implementation("org.scala-lang:scala3-library_3:3.7.0-RC1-bin-20250303-91985db-NIGHTLY")

    // https://mvnrepository.com/artifact/org.mvnpm/tailwindcss
    implementation("org.mvnpm:tailwindcss:4.0.9")

}

tasks.test {
    useJUnitPlatform()
}