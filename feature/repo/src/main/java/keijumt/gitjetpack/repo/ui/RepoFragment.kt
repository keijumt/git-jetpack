package keijumt.gitjetpack.repo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import dagger.android.support.DaggerFragment
import keijumt.gitjetpack.repo.databinding.FragmentRepoBinding
import javax.inject.Inject

class RepoFragment : DaggerFragment() {

    companion object {
        fun newInstance(args: RepoFragmentArgs): RepoFragment {
            return RepoFragment().also {
                it.arguments = args.toBundle()
            }
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentRepoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepoBinding.inflate(
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
        val repoViewModel: RepoViewModel by viewModels { viewModelFactory }
        binding.viewModel = repoViewModel

        val adapter = RepoAdapter()
        binding.recyclerRepo.adapter = adapter

        val args = RepoFragmentArgs.fromBundle(requireNotNull(arguments))
        val tabIndex = args.tabIndex
        // TODO 言語のEnumとか定義しておいてtabIndexとEnum.ordinalを比較する

        repoViewModel.repos.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}
