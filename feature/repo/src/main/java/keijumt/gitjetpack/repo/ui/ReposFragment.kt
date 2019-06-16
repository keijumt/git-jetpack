package keijumt.gitjetpack.repo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import dagger.android.support.DaggerFragment
import keijumt.gitjetpack.repo.databinding.FragmentReposBinding
import javax.inject.Inject

class ReposFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentReposBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReposBinding.inflate(
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
        val repoViewModel: ReposViewModel by viewModels { viewModelFactory }
        binding.viewModel = repoViewModel

        val adapter = RepoAdapter()
        binding.recyclerRepo.adapter = adapter
        
        repoViewModel.repos.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}