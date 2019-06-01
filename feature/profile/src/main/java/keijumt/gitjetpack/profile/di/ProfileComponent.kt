package keijumt.gitjetpack.profile.di

import dagger.Component
import keijumt.gitjetpack.core.di.CoreComponent
import keijumt.gitjetpack.core.di.ModuleScope
import keijumt.gitjetpack.core.di.ViewModelModule
import keijumt.gitjetpack.profile.ui.ProfileFragment

@ModuleScope
@Component(
    modules = [
        ProfileModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface ProfileComponent {

    @Component.Builder
    interface Builder {
        fun build(): ProfileComponent
        fun coreComponent(coreComponent: CoreComponent): Builder
    }

    fun inject(fragment: ProfileFragment)
}