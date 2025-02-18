plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2" // Подключаем плагин Allure
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.aeonbits.owner:owner:1.0.12") // конфигурация owner

    implementation("org.projectlombok:lombok:1.18.30") // lombok
    annotationProcessor("org.projectlombok:lombok:1.18.30") // lombok

    implementation("ch.qos.logback:logback-classic:1.4.14") // логгер

    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0") // jackson

    implementation("io.qameta.allure:allure-rest-assured:2.24.0") // allure rest-assured
    testImplementation("io.qameta.allure:allure-junit5:2.24.0") // allure junit5

    implementation("org.assertj:assertj-core:3.24.2") // assertj

    implementation("org.apache.httpcomponents.core5:httpcore5:5.2")// http methods

    implementation("io.rest-assured:rest-assured:5.4.0") // rest-assured
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("allure.results.directory", "build/allure-results") // Директория для результатов Allure
}
