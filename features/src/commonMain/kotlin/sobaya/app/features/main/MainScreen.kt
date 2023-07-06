package sobaya.app.features.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import sobaya.app.features.sub.SubScreen

class MainScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val model = rememberScreenModel { MainScreenModel() }
        val data = model.data.value

        if (data != null) {
            Column {
                Text(text = data)
                Button(
                    onClick = {
                        navigator.push(SubScreen())
                    }
                ) {
                    Text(text = "SubScreen")
                }
            }
        } else {
            CircularProgressIndicator()
        }
    }
}