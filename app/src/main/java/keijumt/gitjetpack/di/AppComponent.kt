package keijumt.gitjetpack.di

import dagger.Component
import keijumt.gitjetpack.AppActivity
import keijumt.gitjetpack.core.di.CoreComponent
import keijumt.gitjetpack.core.di.ModuleScope

@ModuleScope
@Component(
    modules = [
        AppModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun coreComponent(coreComponent: CoreComponent): Builder
    }

    fun inject(activity: AppActivity)
}