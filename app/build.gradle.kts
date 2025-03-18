plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id ("androidx.navigation.safeargs")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
}

android {
    namespace = "com.zhalz.eventy"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.zhalz.eventy"
        minSdk = 29
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    /*  J Unit  */
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)

    /*  Espresso  */
    androidTestImplementation(libs.androidx.espresso.core)

    /*  Hilt  */
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    /*  Firebase  */
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)

    /*  Crocodic Core  */
    implementation(libs.androidcoreproject)

    /*  Retrofit  */
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    /*  Navigation  */
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    /*  Swipe Refresh  */
    implementation (libs.androidx.swiperefreshlayout)

    /*  Glide  */
    implementation (libs.glide)

    /*  Lottie  */
    implementation (libs.lottie)

    /*  Overlapping Image  */
    implementation(libs.overlapimagelistview)

}