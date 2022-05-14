plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
//    kotlin("plugin.serialization") version "1.6.10"
}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Ktor
//                implementation("io.ktor:ktor-client-core:2.0.0")
//                implementation("io.ktor:ktor-client-content-negotiation:2.0.0")
//                implementation("io.ktor:ktor-serialization-kotlinx-json:2.0.0")

                // Koin
//                api("io.insert-koin:koin-core:3.1.6")

                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1-native-mt") {
                    version {
                        strictly("1.6.1-native-mt")
                    }
                }
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                // Ktor
//                implementation("io.ktor:ktor-client-android:2.0.0")

                // Lifecycle
//                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependencies {
                // Ktor
//                implementation("io.ktor:ktor-client-ios:2.0.0")
            }
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
}
