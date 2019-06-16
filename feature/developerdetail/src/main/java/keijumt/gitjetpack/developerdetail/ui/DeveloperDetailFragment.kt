package keijumt.gitjetpack.developerdetail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.android.support.DaggerFragment
import keijumt.gitjetpack.developerdetail.databinding.FragmentDeveloperDetailBinding
import javax.inject.Inject

class DeveloperDetailFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentDeveloperDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDeveloperDetailBinding.inflate(
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
        val viewModel: DeveloperDetailViewModel by viewModels { viewModelFactory }
        binding.viewModel = viewModel

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        val adapter = DeveloperRepoAdapter()
        binding.recyclerRepo.adapter = adapter

        viewModel.repos.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        val args: DeveloperDetailFragmentArgs by navArgs()
        viewModel.loadProfile(args.userId)
    }

}
