package com.example.useraccount.compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.useraccount.R
import com.example.useraccount.UserAccountViewModel
import com.example.useraccount.ui.theme.NavigationTheme
import com.example.useraccount.ui.theme.PhonePreview

@Composable
fun AddressScreen(
    modifier: Modifier = Modifier,
    viewModel: UserAccountViewModel,
) {
    AddressScreen(
        onNavigateToPhoneNumberScreen = viewModel::onNavigateToPhoneNumberScreen,
        onBackClick = viewModel::onBackClick,
        modifier = modifier,
    )
}

@Composable
private fun AddressScreen(
    onNavigateToPhoneNumberScreen: (String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CustomTextFieldScreen(
        onNavigateScreen = onNavigateToPhoneNumberScreen,
        onBackClick= onBackClick,
        modifier = modifier,
        toolbarLabel = stringResource(id = R.string.address),
        buttonLabel = stringResource(id = R.string.next)
    )

}

@PhonePreview
@Composable
private fun PreviewAddressScreen() {
    NavigationTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AddressScreen(
                onNavigateToPhoneNumberScreen = {  },
                onBackClick = {},
            )
        }
    }
}
