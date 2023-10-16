package sobaya.app.features.native

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import sobaya.app.repository.Sample

class NativeScreenModel() : ScreenModel, KoinComponent {

    private val sample: Sample by inject()
    private val _data = mutableStateOf<String?>(null)
    val data: State<String?> = _data

    init {
        coroutineScope.launch {
            _data.value = sample.Sample()
        }
    }

    suspend fun getSample(): String = sample.Sample()
}