package keijumt.gitjetpack.repo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import keijumt.gitjetpack.repo.R
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
        )

        if (savedInstanceState == null) {
            fragmentManager?.commit {
                // TODO tabIndexを渡すようにする
                add(R.id.container, RepoFragment.newInstance(RepoFragmentArgs.Builder(0).build()))
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val reposViewModel: ReposViewModel by viewModels { viewModelFactory }
    }
}