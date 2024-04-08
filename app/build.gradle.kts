import org.jetbrains.kotlin.daemon.common.ensureServerHostnameIsSetUp

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)


//    kotlin("jvm") version "1.9.20"
//    id("io.qameta.allure") version "2.11.2"
//    id("io.qameta.allure-report") version "2.11.2"
}

//reporting {
//    baseDir = File("allureReports")
//}
//
//allure {
//    version.set("2.19.0")
//    ensureServerHostnameIsSetUp()
//}

////Allure
//val allureVersion = "2.24.0"
//val aspectJVersion = "1.9.20.1"
//val agent: Configuration by configurations.creating {
//    isCanBeConsumed = true
//    isCanBeResolved = true
//}

android {
    namespace = "com.example.homework_8"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.homework_8"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.uiautomator)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

//
//    androidTestImplementation("androidx.test.uiautomator:uiautomator:2.3.0")
//
//    testImplementation("junit:junit:4.13.2")
//    testImplementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
//    testImplementation("io.qameta.allure:allure-junit4")
//
//    agent("org.aspectj:aspectjweaver:${aspectJVersion}")

}

//allure.results.directory=build/allure-results

//tasks.register<GradleBuild>("testAndAllureServe") {
//    tasks = listOf("detekt", "myAllureServe")
//}