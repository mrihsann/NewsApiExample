package com.ihsanarslan.newsapiexample.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Home : Screen

    @Serializable
    data object Detail : Screen
}