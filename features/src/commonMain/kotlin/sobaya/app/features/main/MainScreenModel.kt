package sobaya.app.features.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import sobaya.app.repository.Sample

class MainScreenModel : ScreenModel, KoinComponent {

    private val sample: Sample by inject()
    private val _data = mutableStateOf<String?>(null)
    val data: State<String?> = _data

    init {
        coroutineScope.launch {
            _data.value = sample.sample()
        }
    }

    suspend fun getSample(): String = sample.sample()
}