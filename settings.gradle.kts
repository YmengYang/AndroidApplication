pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Applicationdemo5"
include(":app")
include(":viewpage")
include(":boradcasttest")
include(":broadcastbestpractice")
include(":sharedpreferencestest")
include(":databasetest")
include(":threadtest")
include(":servicetest")
include(":networktest")
