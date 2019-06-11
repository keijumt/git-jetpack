package keijumt.gitjetpack.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.android.support.DaggerAppCompatActivity
import keijumt.gitjetpack.R
import keijumt.gitjetpack.databinding.ActivityMainBinding

class MainActivity : DaggerAppCompatActivity() {

    private val navController: NavController by lazy {
        findNavController(R.id.root_nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
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
