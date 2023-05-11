package dependencies

inline fun appDependencies(block: AppDependencies.() -> Unit) =
    AppDependencies.block()

inline fun AppDependencies.android(block: AppDependencies.Android.() -> Unit) =
    AppDependencies.Android.block()

inline fun AppDependencies.lifecycle(block: AppDependencies.LifeCycle.() -> Unit) =
    AppDependencies.LifeCycle.block()

inline fun AppDependencies.activity(block: AppDependencies.Activity.() -> Unit) =
    AppDependencies.Activity.block()

inline fun AppDependencies.compose(block: AppDependencies.Compose.() -> Unit) =
    AppDependencies.Compose.block()

inline fun AppDependencies.hilt(block: AppDependencies.Hilt.() -> Unit) =
    AppDependencies.Hilt.block()

inline fun AppDependencies.jsonConverter(block: AppDependencies.JsonConverter.() -> Unit) =
    AppDependencies.JsonConverter.block()

inline fun AppDependencies.retrofit(block: AppDependencies.Retrofit.() -> Unit) =
    AppDependencies.Retrofit.block()

inline fun AppDependencies.room(block: AppDependencies.Room.() -> Unit) =
    AppDependencies.Room.block()

inline fun AppDependencies.coil(block: AppDependencies.Coil.() -> Unit) =
    AppDependencies.Coil.block()

inline fun AppDependencies.paging(block: AppDependencies.Paging.() -> Unit) =
    AppDependencies.Paging.block()

inline fun AppDependencies.leekCanary(block: AppDependencies.LeekCanary.() -> Unit) =
    AppDependencies.LeekCanary.block()

inline fun AppDependencies.test(block: AppDependencies.Test.() -> Unit) =
    AppDependencies.Test.block()