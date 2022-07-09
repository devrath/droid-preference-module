apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation"(project(Modules.corePreference))
    "implementation"(project(Modules.coreRepository))
    // -----> DataStore Preferences
    "implementation"(DataStorePreferences.datastorePreferences)
}