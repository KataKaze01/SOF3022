plugins {
    id("java")
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    // 💡 Thêm repo Microsoft để tải JDBC chính thức
    maven { url = uri("https://repo1.maven.org/maven2") }
}

dependencies {
    // --- SPRING CORE ---
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // --- DEVTOOLS ---
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // --- DATABASE (SQL SERVER) ---
    implementation("com.microsoft.sqlserver:mssql-jdbc:11.2.3.jre17")

    // --- JSP & JSTL SUPPORT ---
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper")
    implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0")
    implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1")

    // --- MAIL ---
    implementation("org.springframework.boot:spring-boot-starter-mail")

    // --- SECURITY ---
    implementation("org.springframework.boot:spring-boot-starter-security")

    // --- SECURITY (BCrypt) ---
    implementation("org.mindrot:jbcrypt:0.4")

    // --- LOMBOK ---
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")

    // --- TESTING ---
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

tasks.bootRun {
    sourceResources(sourceSets["main"])
}
