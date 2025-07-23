plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    this.androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.logging)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.koin.android)
                implementation(libs.ktor.client.cio)
            }
        }

//        val iosMain by getting {
//            dependencies {
//                implementation(libs.ktor.client.cio) // Or Darwin, if you prefer
//            }
//        }
    }
}

android {
    namespace = "com.android.pokekmp.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
