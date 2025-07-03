package com.infinitysoftware.frontendwithdatabaseapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.infinitysoftware.notes.ui.theme.DefaultBackgroundColor

@Composable
fun App() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    val lineSpacingDp = 50
    val numberOfLines = screenHeight / lineSpacingDp

    var enteredText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DefaultBackgroundColor)
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(lineSpacingDp.dp))

            for (i in 0..numberOfLines) {
                Divider(
                    color = Color.DarkGray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(lineSpacingDp.dp))
            }
        }
        TextField(
            value = enteredText,
            onValueChange = { enteredText = it},
            textStyle = TextStyle(fontSize = numberOfLines.sp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Transparent,
                cursorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent))
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreviewer() {
    App()
}
