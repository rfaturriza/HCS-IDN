plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kapt)
}

android {
    namespace = "com.rizz.test"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.rizz.test"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
        dataBinding = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.androidx.lifecycle.extensions)
    implementation(libs.androidx.lifecycle.compiler)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.androidx.recyclerview)

    implementation(libs.rxjava)
    implementation(libs.rxandroid)
    implementation(libs.rxbinding.appcompat)

    implementation(libs.workmanager)

    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.retrofit.adapter.rxjava)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.gson)
    implementation(libs.jakewhartonAdapter)

    implementation(libs.room)
    implementation(libs.room.ktx)
    testImplementation(libs.junit.jupiter)
    kapt(libs.room.compiler)

//    implementation(libs.daggers)
    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)
//    implementation(libs.dagger.hilt.compiler)
//    implementation(libs.dagger.android.support)
//    implementation(libs.dagger.compiler)

    implementation(libs.workmanager)

    implementation(libs.glide)
    kapt(libs.glide.compiler)
    implementation(libs.glide.recyclerview.integration)

    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}