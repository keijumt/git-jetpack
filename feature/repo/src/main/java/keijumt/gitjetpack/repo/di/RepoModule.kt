package keijumt.gitjetpack.repo.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import keijumt.gitjetpack.common.ViewModelKey
import keijumt.gitjetpack.repo.ui.ReposFragment
import keijumt.gitjetpack.repo.ui.ReposViewModel

@Module
abstract class RepoModule {

    @ContributesAndroidInjector
    internal abstract fun contributeRespoFragment(): ReposFragment

    @Binds
    @IntoMap
    @ViewModelKey(ReposViewModel::class)
    internal abstract fun bindRepoViewModel(viewModel: ReposViewModel): ViewModel
}