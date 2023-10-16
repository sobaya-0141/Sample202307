package sobaya.app.features.native

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class NativeScreen : Screen {

    @Composable
    override fun Content() {
        native("test")
    }
}

internal expect fun native(test: String)