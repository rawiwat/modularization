object Version{
    const val core = "1.12.0"
    const val glide = "4.12.0"
    const val viewModelDeligate = "1.6.0"
    const val dagger = "2.44"
    const val lifeCycleRuntime = "2.6.2"
    const val composeActivity = "1.7.2"
    const val composeBom = "2023.03.00"
    const val junit = "4.13.2"
    const val extJunit = "1.1.5"
    const val espressoCore = "3.5.1"
}

object Dependencies {
    const val core = "androidx.core:core-ktx:${Version.core}"
    const val lifeCycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifeCycleRuntime}"
    const val composeActivity = "androidx.activity:activity-compose:${Version.composeActivity}"
    const val composeBom = "androidx.compose:compose-bom:${Version.composeBom}"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val junit = "junit:junit:${Version.junit}"
    const val extJunit = "androidx.test.ext:junit${Version.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
    const val junitTest = "androidx.compose.ui:ui-test-junit4"
    const val composeUiTooling= "androidx.compose.ui:ui-tooling"
    const val testManifest = "androidx.compose.ui:ui-test-manifest"

}
object DaggerHilt{
    const val dagger = "com.google.dagger:hilt-android:${Version.dagger}"
}