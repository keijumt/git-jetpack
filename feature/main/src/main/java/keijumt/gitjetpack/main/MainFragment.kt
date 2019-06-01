package keijumt.gitjetpack.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import keijumt.gitjetpack.core.di.CoreComponentProvider
import keijumt.gitjetpack.main.databinding.FragmentMainBinding
import keijumt.gitjetpack.main.di.DaggerMainComponent
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        val coreComponent = (requireActivity().application as CoreComponentProvider).provideCoreComponent()
        DaggerMainComponent.builder()
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
        val mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        val binding = FragmentMainBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }
}
