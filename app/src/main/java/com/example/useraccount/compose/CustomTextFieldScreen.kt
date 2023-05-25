package com.example.useraccount.compose

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.useraccount.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFieldScreen(
    onNavigateScreen: (String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    toolbarLabel: String,
    buttonLabel: String) {


    var textValue by rememberSaveable {
        mutableStateOf("")
    }


    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(toolbarLabel) },
                modifier = Modifier.fillMaxWidth(),
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        if(toolbarLabel != stringResource(id = R.string.full_name)){
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = stringResource(
                            id = R.string.back
                        ))
                    }}
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

        TextField(
            value = textValue,
            onValueChange = { textValue = it },
            label = { Text(toolbarLabel) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
        )
            val context = LocalContext.current

            Button(
            onClick = {
                    if(textValue.isEmpty()){
                        Toast.makeText(context, "You must enter $toolbarLabel",Toast.LENGTH_LONG).show()
                    }else{
                        onNavigateScreen(textValue) }},
            modifier = Modifier.padding(all = 16.dp),
        ) {
            Text(text = buttonLabel)
        }
    }}
}


