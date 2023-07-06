package sobaya.app.repository.di

import org.koin.dsl.module
import sobaya.app.repository.Sample

val networkModule = module {
    single { Sample() }
}