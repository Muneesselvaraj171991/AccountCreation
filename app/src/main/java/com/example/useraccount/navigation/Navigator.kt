package com.example.useraccount.navigation

import androidx.navigation.NavController
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


interface Navigator {
    fun setController(navController: NavController)
    fun navigate(route: NavigationRoute)
    fun popBackStack()
    fun clear()
}

class NavigatorImpl @Inject constructor() : Navigator {

    private var navController: NavController? = null

    override fun setController(navController: NavController) {
        this.navController = navController
    }

    override fun navigate(route: NavigationRoute) {
        navController?.navigate(
            route.buildRoute()
        )
    }

    override fun popBackStack() {
        navController?.popBackStack()
    }


    override fun clear() {
        navController = null
    }
}

@Module
@InstallIn(SingletonComponent::class)
interface NavigatorModule {
    @Binds
    @Singleton
    fun bindNavigator(navigatorImpl: NavigatorImpl): Navigator
}
