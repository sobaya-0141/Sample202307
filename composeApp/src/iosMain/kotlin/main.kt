import androidx.compose.ui.window.ComposeUIViewController
import org.koin.core.context.startKoin
import sobaya.app.sample.App
import platform.UIKit.UIViewController
import sobaya.app.repository.di.networkModule

fun MainViewController(): UIViewController {
    return ComposeUIViewController { App() }
}

fun doInitKoin() {
    startKoin {
        modules(networkModule)
    }
}