# Compose Navigation 3 - Dynamic Destinations Sample

## Project structure

- [nav2/static](app/src/main/java/io/morfly/navsample/nav2/static/NavigationV2Static.kt) -
- [nav3/static](app/src/main/java/io/morfly/navsample/nav3/static/NavigationV3Static.kt) -
- [nav3/dynamic](app/src/main/java/io/morfly/navsample/nav3/dynamic/NavigationV3Dynamic.kt) -

## How to configure sample app

```kotlin
@Composable
fun NavigationContainer(modifier: Modifier = Modifier) {
    // ===== Old Compose Navigation =====
    // val navImplementation = NavImplementation.Nav2Static

    // ===== Navigation 3 Static =====
    // val navImplementation = NavImplementation.Nav3Static

    // ===== Navigation 3 Dynamic =====
    // val navImplementation = NavImplementation.Nav3Dynamic

    NavigationContainer(modifier, navImplementation)
}
```

## License

```
Copyright 2025 Pavlo Stavytskyi.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
