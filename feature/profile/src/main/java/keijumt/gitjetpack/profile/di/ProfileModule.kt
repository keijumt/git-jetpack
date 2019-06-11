package keijumt.gitjetpack.profile.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import keijumt.gitjetpack.common.ViewModelKey
import keijumt.gitjetpack.profile.ui.ProfileFragment
import keijumt.gitjetpack.profile.ui.ProfileViewModel

@Module
abstract class ProfileModule {

    @ContributesAndroidInjector
    internal abstract fun contributeProfileFragment(): ProfileFragment

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    internal abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel
}