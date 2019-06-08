package keijumt.gitjetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import keijumt.gitjetpack.databinding.ActivityMainBinding
import keijumt.gitjetpack.di.DaggerAppComponent

class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy {
        findNavController(R.id.root_nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // Inject!!
        DaggerAppComponent
            .builder()
            .coreComponent(App.coreComponent(this))
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        
        binding.bottomNavigation.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}
