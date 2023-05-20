package com.example.useraccount.navigation

interface NavigationRoute {
    fun buildRoute(): String
}

object NavigationFullNameRoute : NavigationRoute {
    override fun buildRoute(): String = route
    private const val root = "FullName"
    const val route = root
}



object NavigationAddressRoute : NavigationRoute {
    override fun buildRoute(): String = route

    private const val root = "Address"
    const val route = root
}


object NavigationPhoneNumberRoute : NavigationRoute {
    override fun buildRoute(): String = route

    private const val root = "PhoneNumber"
    const val route = root
}

