package com.example.useraccount.compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.useraccount.R
import com.example.useraccount.UserAccountViewModel
import com.example.useraccount.ui.theme.PhonePreview
import com.example.useraccount.ui.theme.NavigationTheme
import com.example.useraccount.ui.theme.TabletPreview

@Composable
fun FullNameScreen(
    modifier: Modifier = Modifier,
    viewModel: UserAccountViewModel,
) {
    FullNameScreen (
        onNavigateToAddressScreen = viewModel::onNavigateToAddressScreen,
        onBackClick = viewModel::onBackClick,
        modifier = modifier,
    )
}

@Composable
private fun FullNameScreen(
    onNavigateToAddressScreen: (String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
                    CustomTextFieldScreen(
                    onNavigateScreen = onNavigateToAddressScreen,
                    onBackClick = onBackClick,
                    modifier = modifier,
                    toolbarLabel = stringResource(id = R.string.full_name),
                    buttonLabel = stringResource(id = R.string.next)
                )




}

@PhonePreview
@TabletPreview
@Composable
private fun PreviewFullNameScreen() {
    NavigationTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            FullNameScreen(
                onNavigateToAddressScreen = {},
                onBackClick = {}
            )
        }
    }
}
