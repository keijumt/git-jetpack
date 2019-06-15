package keijumt.gitjetpack.feed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import dagger.android.support.DaggerFragment
import keijumt.gitjetpack.feed.databinding.FragmentFeedBinding
import javax.inject.Inject

class FeedFragment : DaggerFragment() {

    companion object {
        fun newInstance(args: FeedFragmentArgs): FeedFragment {
            return FeedFragment().also {
                it.arguments = args.toBundle()
            }
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentFeedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(
            inflater,
            container,
            false
        ).also {
            it.lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val feedViewModel: FeedViewModel by viewModels { viewModelFactory }
        binding.viewModel = feedViewModel

        val adapter = FeedAdapter()
        binding.recyclerFeed.adapter = adapter

        val args = FeedFragmentArgs.fromBundle(requireNotNull(arguments))
        val tabIndex = args.tabIndex
        // TODO 言語のEnumとか定義しておいてtabIndexとEnum.ordinalを比較する

        feedViewModel.repos.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}
