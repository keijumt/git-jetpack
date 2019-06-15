package keijumt.gitjetpack.developer.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import keijumt.gitjetpack.common.ViewModelKey
import keijumt.gitjetpack.developer.ui.DevelopersFragment
import keijumt.gitjetpack.developer.ui.DevelopersViewModel

@Module
abstract class DeveloperModule {

    @ContributesAndroidInjector
    internal abstract fun contributeDeveloperFragment(): DevelopersFragment

    @Binds
    @IntoMap
    @ViewModelKey(DevelopersViewModel::class)
    internal abstract fun bindDeveloperViewModel(viewModel: DevelopersViewModel): ViewModel
}