package sobaya.app.sample

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.core.context.startKoin
import sobaya.app.repository.di.networkModule
import org.koin.android.ext.koin.androidContext

class AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AndroidApp)
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
