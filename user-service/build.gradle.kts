import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.7"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    /**
     * 아래 어노테이션이 붙은 클래스에 대해 open을 자동으로 적용
     * @Component 포함 모든 스테레오 타입
     * @Async
     * @Transactional
     * @Cacheable
     * @SpringBootTest
     */
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("kapt") version "1.6.21"
}

group = "com.tme"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2021.0.5"

dependencies {
    ///// spring /////
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    ///// spring cloud /////
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    ///// h2 (1.3.176 버전 사용해야 서버 로드 시 데이터베이스 자동 생성) /////
    runtimeOnly("com.h2database:h2:1.4.200")

    ///// kotlin /////
    // 1. 기존 jackson 라이브러리는 class를 deserialize 시 기본 생성자가 필요
    // 2. data class는 all args 생성자만 만들어주기 때문에 deserialize 시 에러 발생
    // 3. 해당 라이브러리는 단일 생성자로 deserialize가 가능
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    // 코틀린은 런타임 라이브러리의 용량을 줄이기 위해 기본적으로 리플렉션을 제공하지 않음
    // Spring framework 5 이후 수동으로 추가 해야함
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    // jdk8 기능과 호환되는 코틀린 표준 라이브러리 제공
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    ///// querydsl /////
    implementation("com.querydsl:querydsl-jpa:5.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    implementation ("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.8.0")

    ///// modelmapper /////
    implementation("org.modelmapper:modelmapper:3.1.1")

    ///// test /////
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
