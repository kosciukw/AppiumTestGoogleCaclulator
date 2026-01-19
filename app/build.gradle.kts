plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.uiautomation.test"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.uiautomation.calculatortest"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    testOptions {
        unitTests {
            all {
                it.useTestNG()
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Appium
    testImplementation("io.appium:java-client:9.3.0")

    // Selenium + WebDriver
    testImplementation("org.seleniumhq.selenium:selenium-java:4.23.0")

    // TestNG
    testImplementation("org.testng:testng:7.11.0")

    // Cucumber + TestNG
    testImplementation("io.cucumber:cucumber-testng:7.29.0")
    testImplementation("io.cucumber:cucumber-java:7.29.0")
    testImplementation("io.cucumber:cucumber-picocontainer:7.29.0")

    // Reporting
    testImplementation("com.vimalselvam:cucumber-extentsreport:3.1.1")
    testImplementation("io.qameta.allure:allure-cucumber-jvm:2.20.1")
}