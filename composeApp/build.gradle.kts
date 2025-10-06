import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    with(libs.plugins) {
        listOf(
            kotlinMultiplatform,
            androidApplication,
            composeMultiplatform,
            composeCompiler,
            serialization,
            ksp,
            roomGradlePlugin,
            googleServices
        )
    }.forEach {
        alias(it)
    }
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidxActivityCompose)
            implementation(libs.ktorAndroid)
            implementation(libs.timber)
            implementation(libs.bundles.koinAndroid)

        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.koinCore)
            implementation(libs.androidxCoreKtx)
            implementation(libs.roomRuntime)
            implementation(libs.sqliteBundled)
            implementation(libs.composeNavigation)
            implementation(libs.bundles.dataStore)
            implementation(libs.bundles.ktorMultiplatform)
            implementation(libs.bundles.coil)
            implementation(libs.bundles.firebase)
        }

        commonTest.dependencies {
            implementation(libs.kotlinTest)
        }

        iosMain.dependencies {
            implementation(libs.ktorIos)
        }
    }
}

android {
    namespace = "project.play.ground.jg"
    compileSdk = libs.versions.androidCompileSdk.get().toInt()

    defaultConfig {
        applicationId = "project.play.ground.jg"
        minSdk = libs.versions.androidMinSdk.get().toInt()
        targetSdk = libs.versions.androidTargetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {
    add("kspCommonMainMetadata", libs.roomCompiler)
    add("kspAndroid", libs.roomCompiler)
    add("kspIosSimulatorArm64", libs.roomCompiler)
    add("kspIosX64", libs.roomCompiler)
    add("kspIosArm64", libs.roomCompiler)
    debugImplementation(compose.uiTooling)
}
