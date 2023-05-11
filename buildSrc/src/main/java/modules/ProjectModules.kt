package modules

object ProjectModules {

    object Core {
        private const val name = "core"
        const val common = ":$name:common"
        const val dispatchers = ":$name:dispatchers"
        const val dispatchersTesting = "$dispatchers-testing"
        const val network = ":$name:network"
        const val navigation = ":$name:navigation"
        const val testing = ":$name:testing"
        const val ui = ":$name:ui"
    }

    object Data {
        private const val name = "data"
        const val arts = ":$name:arts-data"
        const val artsTesting = "$arts-testing"
        const val common = ":$name:common"
    }

    object Domain {
        private const val name = "domain"
        const val arts = ":$name:artsdomain"
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