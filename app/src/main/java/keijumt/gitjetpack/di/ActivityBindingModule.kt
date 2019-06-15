package keijumt.gitjetpack.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import keijumt.gitjetpack.feed.di.FeedModule
import keijumt.gitjetpack.developer.di.DeveloperModule
import keijumt.gitjetpack.ui.MainActivity

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            FeedModule::class,
            DeveloperModule::class
        ]
    )
    internal abstract fun contributeMainActivity(): MainActivity
}