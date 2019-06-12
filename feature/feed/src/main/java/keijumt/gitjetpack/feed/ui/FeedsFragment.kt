package keijumt.gitjetpack.feed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import keijumt.gitjetpack.feed.R
import keijumt.gitjetpack.feed.databinding.FragmentFeedsBinding
import javax.inject.Inject

class FeedsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentFeedsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedsBinding.inflate(
            inflater,
            container,
            false
        )

        if (savedInstanceState == null) {
            fragmentManager?.commit {
                // TODO tabIndexを渡すようにする
                add(R.id.container, FeedFragment.newInstance(FeedFragmentArgs.Builder(0).build()))
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO ViewPagerにFeedFragmentを設定する
        val feedsViewModel: FeedsViewModel by viewModels { viewModelFactory }
    }
}