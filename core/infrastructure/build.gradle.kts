plugins {
    id("spring-boot-conventions")
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:application"))
}