plugins {
    id("bootstrap-conventions")
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:application"))
    implementation(project(":core:infrastructure"))
}