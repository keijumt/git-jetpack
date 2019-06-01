package keijumt.gitjetpack.main.di

import dagger.Component
import keijumt.gitjetpack.core.di.CoreComponent
import keijumt.gitjetpack.core.di.ModuleScope
import keijumt.gitjetpack.core.di.ViewModelModule
import keijumt.gitjetpack.main.MainFragment

@ModuleScope
@Component(
    modules = [
        MainModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface MainComponent {

    @Component.Builder
    interface Builder {
        fun build(): MainComponent
        fun coreComponent(coreComponent: CoreComponent): Builder
    }

    fun inject(fragment: MainFragment)
}