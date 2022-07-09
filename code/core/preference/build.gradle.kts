apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    // -----> DataStore Preferences
    "implementation"(DataStorePreferences.datastorePreferences)
    "implementation"(AndroidX.coreKtx)
}