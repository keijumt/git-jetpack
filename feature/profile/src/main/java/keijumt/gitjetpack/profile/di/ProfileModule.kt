package keijumt.gitjetpack.profile.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import keijumt.gitjetpack.core.di.ViewModelKey
import keijumt.gitjetpack.profile.ui.ProfileViewModel

@Module
abstract class ProfileModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    internal abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel
}