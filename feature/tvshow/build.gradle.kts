plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.feature.tvshow"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/**"
        }
    }
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.core.designsystem)
    implementation(projects.core.data)
    with(libs) {
        implementation(hilt.compose)
        implementation(hilt.android)
        kapt(hilt.compiler)
        implementation(androidx.paging.runtime.ktx)
        implementation(androidx.paging.compose)
        implementation(androidx.core.ktx)
        implementation(coil)
        implementation(androidx.material3)
        implementation(compose.navigation)
        implementation(androidx.ui.graphics)
        implementation(androidx.activity.compose)
        implementation(androidx.ui.tooling.preview)
        implementation(androidx.lifecycle.runtime.ktx)
        implementation(accompanist.systemuicontroller)
        implementation(platform(androidx.compose.bom))
        implementation(kotlinx.serialization.json)
        implementation(androidx.core.ktx)
        implementation(androidx.appcompat)
        implementation(material)
        testImplementation(junit)
        androidTestImplementation(androidx.junit)
        androidTestImplementation(androidx.espresso.core)
    }
}