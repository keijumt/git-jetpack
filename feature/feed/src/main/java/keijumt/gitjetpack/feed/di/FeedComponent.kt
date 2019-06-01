package keijumt.gitjetpack.feed.di

import dagger.Component
import keijumt.gitjetpack.core.di.CoreComponent
import keijumt.gitjetpack.core.di.ModuleScope
import keijumt.gitjetpack.core.di.ViewModelModule
import keijumt.gitjetpack.feed.ui.FeedsFragment

@ModuleScope
@Component(
    modules = [
        FeedModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface FeedComponent {

    @Component.Builder
    interface Builder {
        fun build(): FeedComponent
        fun coreComponent(coreComponent: CoreComponent): Builder
    }

    fun inject(fragment: FeedsFragment)
}