package com.example.useraccount

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.useraccount.compose.AddressScreen
import com.example.useraccount.compose.FullNameScreen
import com.example.useraccount.compose.PhoneNumberScreen
import com.example.useraccount.navigation.NavigationAddressRoute
import com.example.useraccount.navigation.NavigationFullNameRoute
import com.example.useraccount.navigation.NavigationPhoneNumberRoute
import com.example.useraccount.navigation.Navigator
import com.example.useraccount.ui.theme.NavigationTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserAccountActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    DisposableEffect(key1 = navController) {
                        navigator.setController(navController)
                        onDispose {
                            navigator.clear()
                        }
                    }
                    val userAccountViewModel: UserAccountViewModel = hiltViewModel()

                    NavHost(
                        navController = navController,
                        startDestination = NavigationFullNameRoute.route,
                    ) {
                        composable(route = NavigationFullNameRoute.route) {
                            FullNameScreen(
                                modifier = Modifier.fillMaxSize(),userAccountViewModel
                            )
                        }
                        composable(route = NavigationAddressRoute.route) {
                            AddressScreen(
                                modifier = Modifier.fillMaxSize(),userAccountViewModel
                            )
                        }
                        composable(
                            route = NavigationPhoneNumberRoute.route
                        ) {
                            PhoneNumberScreen(
                                modifier = Modifier.fillMaxSize(),userAccountViewModel
                            )
                        }
                    }
                }
            }
            BackHandler {
                finishAffinity()
            }

        }
    }
}
