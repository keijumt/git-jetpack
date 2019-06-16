package keijumt.gitjetpack.repo.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import keijumt.gitjetpack.common.ViewModelKey
import keijumt.gitjetpack.repo.ui.RepoFragment
import keijumt.gitjetpack.repo.ui.RepoViewModel
import keijumt.gitjetpack.repo.ui.ReposFragment
import keijumt.gitjetpack.repo.ui.ReposViewModel

@Module
abstract class RepoModule {

    @ContributesAndroidInjector
    internal abstract fun contributeRespoFragment(): ReposFragment

    @ContributesAndroidInjector
    internal abstract fun contributeRepoFragment(): RepoFragment

    @Binds
    @IntoMap
    @ViewModelKey(ReposViewModel::class)
    internal abstract fun bindReposViewModel(viewModel: ReposViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RepoViewModel::class)
    internal abstract fun bindRepoViewModel(viewModel: RepoViewModel): ViewModel
}