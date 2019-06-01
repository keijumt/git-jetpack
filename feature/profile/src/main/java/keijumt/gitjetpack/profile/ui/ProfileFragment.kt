package keijumt.gitjetpack.profile.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import keijumt.gitjetpack.core.di.CoreComponentProvider
import keijumt.gitjetpack.core.di.ViewModelFactory
import keijumt.gitjetpack.profile.databinding.FragmentProfileBinding
import keijumt.gitjetpack.profile.di.DaggerProfileComponent
import javax.inject.Inject

class ProfileFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        val coreComponent = (requireActivity().application as CoreComponentProvider).provideCoreComponent()
        DaggerProfileComponent.builder()
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
        val binding = FragmentProfileBinding.inflate(
            inflater,
            container,
            false
        )
        val profileViewModel = ViewModelProviders.of(this, viewModelFactory).get(ProfileViewModel::class.java)
        return binding.root
    }
}