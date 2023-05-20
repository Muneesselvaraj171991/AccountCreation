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
fun PhoneNumberScreen(
    modifier: Modifier = Modifier,
    viewModel: UserAccountViewModel,
) {
    PhoneNumberScreen(
        onAccountCreate = viewModel::onAccountCreate,
        onBackClick = viewModel::onBackClick,
        modifier = modifier,
    )
}

@Composable
private fun PhoneNumberScreen(
    onAccountCreate: (String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CustomTextFieldScreen(
        onNavigateScreen = onAccountCreate,
        onBackClick= onBackClick,
        modifier = modifier,
        toolbarLabel = stringResource(id = R.string.phone_number),
        buttonLabel = stringResource(id = R.string.create_account)
    )

}

@PhonePreview
@Composable
private fun PreviewPhoneNumberScreen() {
    NavigationTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            PhoneNumberScreen(
                onAccountCreate = {  },
                onBackClick = {},
            )
        }
    }
}
