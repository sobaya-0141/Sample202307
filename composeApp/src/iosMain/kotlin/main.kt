import androidx.compose.ui.window.ComposeUIViewController
import sobaya.app.sample.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    return ComposeUIViewController { App() }
}
