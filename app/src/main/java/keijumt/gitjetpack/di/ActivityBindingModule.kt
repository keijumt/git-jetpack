package keijumt.gitjetpack.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import keijumt.gitjetpack.developer.di.DeveloperModule
import keijumt.gitjetpack.developerdetail.di.DeveloperDetailModule
import keijumt.gitjetpack.repo.di.RepoModule
import keijumt.gitjetpack.ui.MainActivity

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            RepoModule::class,
            DeveloperModule::class,
            DeveloperDetailModule::class
        ]
    )
    internal abstract fun contributeMainActivity(): MainActivity
}