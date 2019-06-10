package keijumt.gitjetpack.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import keijumt.gitjetpack.App
import keijumt.gitjetpack.R
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
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val config = PageConfiguration.getConfiguration(destination.id)

            if (config.hideToolbar) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }

            if (!config.hasTitle) {
                supportActionBar?.title = ""
            }

            supportActionBar?.setDisplayHomeAsUpEnabled(config.displayHomeAsUpEnabled)

            binding.bottomNavigation.visibility = if (config.hideBottomNavigation) {
                View.GONE
            } else {
                View.VISIBLE
            }
        }

        binding.bottomNavigation.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}
