package sobaya.app.sample

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import dev.icerock.moko.resources.desc.desc
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import sobaya.app.repository.di.networkModule

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
        setContent {
            Column {
                Text(
                    text = getTestString().toString(context = LocalContext.current),
                    color = Color.Red,
                )
                Text(
                    text = MR.strings.test.desc().toString(context = LocalContext.current),
                    color = Color.Blue,
                )
            }
        }
    }
}
