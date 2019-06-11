package keijumt.gitjetpack.feed.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import keijumt.gitjetpack.common.ViewModelKey
import keijumt.gitjetpack.feed.ui.FeedsFragment
import keijumt.gitjetpack.feed.ui.FeedsViewModel

@Module
abstract class FeedModule {

    @ContributesAndroidInjector
    internal abstract fun contributeFeedsFragment(): FeedsFragment

    @Binds
    @IntoMap
    @ViewModelKey(FeedsViewModel::class)
    internal abstract fun bindFeedsViewModel(viewModel: FeedsViewModel): ViewModel
}