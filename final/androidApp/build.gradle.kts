
plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "dev.tutorial.kmmargherita.android"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    // Jetpack Compose
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.6.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")

    // Koin
    implementation("io.insert-koin:koin-android:3.1.6")

    // Jetpack Compose
    implementation("androidx.compose.ui:ui:1.1.1")
    implementation("androidx.compose.ui:ui-graphics:1.1.1")
    implementation("androidx.compose.ui:ui-tooling:1.1.1")
    implementation("androidx.compose.foundation:foundation-layout:1.1.1")
    implementation("androidx.compose.material:material:1.1.1")
    implementation("androidx.navigation:navigation-compose:2.5.0-beta01")
    implementation("androidx.activity:activity-compose:1.6.0-alpha03")
}