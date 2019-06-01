package keijumt.gitjetpack.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import keijumt.gitjetpack.main.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val binding = FragmentMainBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }
}
