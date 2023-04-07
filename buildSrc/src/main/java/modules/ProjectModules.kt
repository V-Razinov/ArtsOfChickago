package modules

object ProjectModules {

    object Core {
        private const val name = "core"
        const val network = ":$name:network"
        const val navigation = ":$name:navigation"
        const val ui = ":$name:ui"
    }

    object Data {
        private const val name = "data"
        const val artOfChicago = ":$name:artsofchicago"
    }

    object Features {
        private const val name = "feature"
        const val arts = ":$name:arts"
        const val splash =":$name:splash"
    }

    object Utils {
        const val utils = ":utils"
    }
}