package keijumt.gitjetpack.ui

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.android.support.DaggerAppCompatActivity
import keijumt.gitjetpack.R
import keijumt.gitjetpack.databinding.ActivityMainBinding

class MainActivity : DaggerAppCompatActivity() {

    companion object {
        private const val COLOR_STATUS_BAR_INVISIBLE = Color.TRANSPARENT
        private const val COLOR_STATUS_BAR_VISIBLE = 0x8a000000.toInt()
    }

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

        val isNightMode = isNightMode(this)
        if (Build.VERSION.SDK_INT >= 23) {
            window.decorView.systemUiVisibility = if (isNightMode) {
                0
            } else {
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
        window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar)

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

    private fun isNightMode(context: Context): Boolean {
        return when (context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> true
            Configuration.UI_MODE_NIGHT_NO -> false
            Configuration.UI_MODE_NIGHT_UNDEFINED -> false
            else -> false
        }
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}
