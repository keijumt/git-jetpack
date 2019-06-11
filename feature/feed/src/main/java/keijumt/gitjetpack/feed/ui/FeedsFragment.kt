package keijumt.gitjetpack.feed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import keijumt.gitjetpack.feed.databinding.FragmentFeedsBinding
import javax.inject.Inject

class FeedsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

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