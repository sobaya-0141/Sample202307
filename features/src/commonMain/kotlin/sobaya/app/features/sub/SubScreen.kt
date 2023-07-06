package sobaya.app.features.sub

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import sobaya.app.features.main.MainScreenModel

class SubScreen : Screen {
    @Composable
    override fun Content() {
        val model = rememberScreenModel { MainScreenModel() }
        Text(
            text = "SubScreen",
        )
    }
}