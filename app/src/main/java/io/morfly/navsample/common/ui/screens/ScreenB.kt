package io.morfly.navsample.common.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScreenB(
    modifier: Modifier = Modifier,
    number: Int,
    onNext: () -> Unit
) {
    GenericScreen(
        modifier = modifier,
        name = "ScreenB",
        number = number,
        onNext = onNext
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewScreenB() {
    ScreenB(
        modifier = Modifier,
        number = 5,
        onNext = {}
    )
}