package sobaya.app.sample

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.core.context.GlobalContext
import sobaya.app.repository.di.networkModule

class AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            modules(
                networkModule,
            )
        }
    }
}

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { App() }
    }
}
