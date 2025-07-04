package com.infinitysoftware.frontendwithdatabaseapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.infinitysoftware.notes.ui.theme.DefaultBackgroundColor
import com.infinitysoftware.notes.ui.theme.DefaultFontColor
import com.infinitysoftware.notes.ui.theme.DefaultLineColor
import java.io.OutputStreamWriter

// Composable Application Function.
@Composable
fun App() {

    // Application Settings Section
    // Custom Variable/Constants Section
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    val defaultFontSize = 30
    val lineSpacing = 34
    val numberOfLines = screenHeight / lineSpacing

    // Remember Variable/Constants Section.
    var enteredText by remember { mutableStateOf("") }

    // Application UI/GUI Section.
    Box(modifier = Modifier
            .fillMaxSize()
            .background(DefaultBackgroundColor)
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        // USING THIS LOC ONLY IN DEVELOPMENT STAGE.
        // Text(text = "${numberOfLines}", color = Color.Green)

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height((lineSpacing + 11).dp))

            // Looping Through Screen Size (Render As Many Lines AS Needed By Screen Size)
            for (i in 0..numberOfLines) {
                Divider(
                    color = DefaultLineColor,
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(lineSpacing.dp))
            }
        }
        TextField(
            value = enteredText,
            onValueChange = { enteredText = it},
            textStyle = TextStyle(
                fontSize = defaultFontSize.sp,
                fontFamily = FontFamily.Default,
                color = DefaultFontColor),

            colors = TextFieldDefaults.colors(
                focusedTextColor = DefaultFontColor,
                unfocusedTextColor = Color.Transparent,
                cursorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent)
        )
    }
}