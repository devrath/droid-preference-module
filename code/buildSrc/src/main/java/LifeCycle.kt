object LifeCycle {
    private const val version = "2.5.0"
    // ViewModel
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    // LiveData
    const val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
    // Lifecycles only (without ViewModel or LiveData)
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
    // Saved state module for ViewModel
    const val lifecycleViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$version"
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    const val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"

    // Annotation processor - Ktx
    const val lifeCycleCompiler = "androidx.lifecycle:lifecycle-compiler:$version"

}


