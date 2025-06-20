/*
 * Copyright 2025 Pavlo Stavytskyi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.morfly.navsample.common.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScreenC(
    modifier: Modifier = Modifier,
    number: Int,
    onNext: () -> Unit
) {
    GenericScreen(
        modifier = modifier,
        name = "ScreenC",
        number = number,
        onNext = onNext
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewScreenC() {
    ScreenB(
        modifier = Modifier,
        number = 5,
        onNext = {}
    )
}