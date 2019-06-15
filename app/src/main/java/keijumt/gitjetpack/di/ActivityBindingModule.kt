package keijumt.gitjetpack.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import keijumt.gitjetpack.developer.di.DeveloperModule
import keijumt.gitjetpack.developerdetail.di.DeveloperDetailModule
import keijumt.gitjetpack.feed.di.FeedModule
import keijumt.gitjetpack.ui.MainActivity

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            FeedModule::class,
            DeveloperModule::class,
            DeveloperDetailModule::class
        ]
    )
    internal abstract fun contributeMainActivity(): MainActivity
}