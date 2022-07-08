apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation"(project(Modules.corePreference))
    "implementation"(project(Modules.coreRepository))
    // -----> DataStore Preferences
    //implementation("androidx.datastore:datastore-preferences:1.0.0")
}