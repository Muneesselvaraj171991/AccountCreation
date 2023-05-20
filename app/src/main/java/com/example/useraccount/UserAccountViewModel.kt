package com.example.useraccount

import androidx.lifecycle.ViewModel
import com.example.useraccount.navigation.NavigationAddressRoute
import com.example.useraccount.navigation.NavigationPhoneNumberRoute
import com.example.useraccount.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserAccountViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel() {

    private var mFullName = ""
    private var mAddress = ""
    private var mPhoneNumber = ""

    fun onBackClick() {
        navigator.popBackStack()
    }


    fun onNavigateToAddressScreen(name: String) {
        mFullName = name
            navigator.navigate(
                NavigationAddressRoute)
    }

    fun onNavigateToPhoneNumberScreen(address: String) {
        mAddress = address
        navigator.navigate(
            NavigationPhoneNumberRoute)
    }

    fun onAccountCreate(phonenumber: String) {
        mPhoneNumber = phonenumber

        // To-do : Web api call for account creation

    }

}
