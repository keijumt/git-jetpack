package keijumt.gitjetpack.feed.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import keijumt.gitjetpack.core.di.CoreComponentProvider
import keijumt.gitjetpack.core.di.ViewModelFactory
import keijumt.gitjetpack.feed.databinding.FragmentFeedsBinding
import keijumt.gitjetpack.feed.di.DaggerFeedComponent
import javax.inject.Inject

class FeedsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        val coreComponent = (requireActivity().application as CoreComponentProvider).provideCoreComponent()
        DaggerFeedComponent.builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFeedsBinding.inflate(
            inflater,
            container,
            false
        )
        val feedsViewModel = ViewModelProviders.of(this, viewModelFactory).get(FeedsViewModel::class.java)
        return binding.root
    }
}