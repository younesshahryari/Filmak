package com.example.app.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.app.R
import com.example.core.icon.FilmakIcons
import com.example.feature.tvshow.navigation.TvShowDestination
import com.example.movie.navigation.MovieDestination
import kotlin.reflect.KClass

enum class TopLevelDestination(
    @StringRes val tabName: Int,
    @StringRes val toolbarTitle: Int,
    val icon: ImageVector,
    val route: KClass<*>,
    val baseRoute: KClass<*> = route,
) {
    Movie(
        baseRoute = MovieDestination.BaseRoute::class,
        route = MovieDestination.TopRoute::class,
        tabName = R.string.movie,
        toolbarTitle = R.string.popular_tv_movies,
        icon = FilmakIcons.Home,
    ),
    Show(
        baseRoute = TvShowDestination.BaseRoute::class,
        route = TvShowDestination.TopRoute::class,
        tabName = R.string.tv_show,
        toolbarTitle = R.string.popular_tv_shows,
        icon = FilmakIcons.PlayArrow,
    )
}