package io.morfly.navsample.common.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenA(
    modifier: Modifier = Modifier,
    onNext: () -> Unit
) {
    Column(modifier) {
        Text(text = "ScreenA")
        Spacer(Modifier.height(16.dp))
        Button(onClick = onNext) {
            Text(text = "Next")
        }
    }
}