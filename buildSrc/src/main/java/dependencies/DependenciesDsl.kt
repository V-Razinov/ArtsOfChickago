package dependencies

inline fun appDependencies(block: AppDependencies.() -> Unit): Unit =
    AppDependencies.block()

inline fun AppDependencies.android(block: AppDependencies.Android.() -> Unit): Unit =
    AppDependencies.Android.block()

inline fun AppDependencies.lifecycle(block: AppDependencies.LifeCycle.() -> Unit): Unit =
    AppDependencies.LifeCycle.block()

inline fun AppDependencies.activity(block: AppDependencies.Activity.() -> Unit): Unit =
    AppDependencies.Activity.block()

inline fun AppDependencies.compose(block: AppDependencies.Compose.() -> Unit): Unit =
    AppDependencies.Compose.block()

inline fun AppDependencies.hilt(block: AppDependencies.Hilt.() -> Unit): Unit =
    AppDependencies.Hilt.block()

inline fun AppDependencies.retrofit(block: AppDependencies.Retrofit.() -> Unit): Unit =
    AppDependencies.Retrofit.block()

inline fun AppDependencies.dagger(block: AppDependencies.Dagger.() -> Unit): Unit =
    AppDependencies.Dagger.block()

inline fun AppDependencies.leekCanary(block: AppDependencies.LeekCanary.() -> Unit): Unit =
    AppDependencies.LeekCanary.block()

inline fun AppDependencies.test(block: AppDependencies.Test.() -> Unit): Unit =
    AppDependencies.Test.block()