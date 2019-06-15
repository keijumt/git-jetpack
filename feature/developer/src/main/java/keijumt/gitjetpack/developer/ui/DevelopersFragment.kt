package keijumt.gitjetpack.developer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import dagger.android.support.DaggerFragment
import keijumt.gitjetpack.developer.databinding.FragmentDevelopersBinding
import javax.inject.Inject

class DevelopersFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentDevelopersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDevelopersBinding.inflate(
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

        val developersViewModel: DevelopersViewModel by viewModels { viewModelFactory }
        binding.viewModel = developersViewModel

        val adapter = DeveloperAdapter()
        binding.recyclerDeveloper.adapter = adapter

        developersViewModel.owner.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        developersViewModel.loadUsers("a")
    }
}