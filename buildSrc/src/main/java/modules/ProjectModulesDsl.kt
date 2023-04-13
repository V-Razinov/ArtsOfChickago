package modules

inline fun projectModules(block: ProjectModules.() -> Unit) = ProjectModules.block()

inline fun ProjectModules.core(block: ProjectModules.Core.() -> Unit) =
    ProjectModules.Core.block()

inline fun ProjectModules.data(block: ProjectModules.Data.() -> Unit) =
    ProjectModules.Data.block()

inline fun ProjectModules.domain(block: ProjectModules.Domain.() -> Unit) =
    ProjectModules.Domain.block()

inline fun ProjectModules.features(block: ProjectModules.Features.() -> Unit) =
    ProjectModules.Features.block()

val ProjectModules.utils: String get() = ProjectModules.Utils.utils