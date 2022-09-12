plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("android")
}

val composeVersion = "1.2.1"

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.emma_ea.hellokmm.android"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))

    implementation ("androidx.appcompat:appcompat-resources:1.5.1")
    implementation ("androidx.appcompat:appcompat:1.3.1")
    implementation ("com.google.android.material:material:1.4.0")


    implementation ("androidx.compose.compiler:compiler:1.3.1")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation ("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    implementation ("androidx.compose.ui:ui:$composeVersion")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")

    debugImplementation ("androidx.compose.ui:ui-tooling:$composeVersion")

}