package keijumt.gitjetpack.developer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import keijumt.gitjetpack.developer.databinding.FragmentDevelopersBinding
import javax.inject.Inject

class DevelopersFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDevelopersBinding.inflate(
            inflater,
            container,
            false
        )
        val developersViewModel = ViewModelProviders.of(this, viewModelFactory).get(DevelopersViewModel::class.java)
        return binding.root
    }
}