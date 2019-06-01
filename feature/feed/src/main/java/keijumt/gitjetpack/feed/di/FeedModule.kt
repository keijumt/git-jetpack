package keijumt.gitjetpack.feed.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import keijumt.gitjetpack.core.di.ViewModelKey
import keijumt.gitjetpack.feed.ui.FeedsViewModel

@Module
abstract class FeedModule {

    @Binds
    @IntoMap
    @ViewModelKey(FeedsViewModel::class)
    internal abstract fun bindFeedsViewModel(viewModel: FeedsViewModel): ViewModel
}