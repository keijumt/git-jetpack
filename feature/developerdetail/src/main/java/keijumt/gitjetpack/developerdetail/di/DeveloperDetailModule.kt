package keijumt.gitjetpack.developerdetail.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import keijumt.gitjetpack.common.ViewModelKey
import keijumt.gitjetpack.developerdetail.ui.DeveloperDetailFragment
import keijumt.gitjetpack.developerdetail.ui.DeveloperDetailViewModel

@Module
abstract class DeveloperDetailModule {

    @ContributesAndroidInjector
    internal abstract fun contributeDeveloperDetailFragment(): DeveloperDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(DeveloperDetailViewModel::class)
    internal abstract fun bindDeveloperDetailViewModel(viewModel: DeveloperDetailViewModel): ViewModel
}