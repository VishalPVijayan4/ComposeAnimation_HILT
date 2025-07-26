package com.vishalpvijayan.composeanimation_hilt.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.vishalpvijayan.composeanimation_hilt.R


@Composable
fun ButtonWithGif(onActionButtonClick: () -> Unit) {
    Button(
        onClick = onActionButtonClick,
        modifier = Modifier.wrapContentWidth()
    ) {
        Row {
            Text("Save in Gold")
            // Add space between text and GIF
            Spacer(modifier = Modifier.size(8.dp))

            // Load GIF from drawable
            Image(
                painter = rememberAsyncImagePainter(model = R.drawable.ann),
                contentDescription = "Save animation",
                modifier = Modifier.size(24.dp) // adjust size as needed
            )
        }
    }
}
