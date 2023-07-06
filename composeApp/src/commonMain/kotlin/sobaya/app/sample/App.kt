package sobaya.app.sample

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import sobaya.app.features.main.MainScreen
import sobaya.app.sample.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    Navigator(
        screen = MainScreen(),
    )
}
