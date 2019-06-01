package keijumt.gitjetpack.core.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CoreModule::class
    ]
)
interface CoreComponent {

    @Component.Builder
    interface Builder {
        fun build(): CoreComponent
        fun coreModule(coreModule: CoreModule): Builder
    }
}