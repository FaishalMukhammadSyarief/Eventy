package com.zhalz.eventy.presentation.main

import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.crocodic.core.base.activity.NoViewModelActivity
import com.crocodic.core.extension.tos
import com.zhalz.eventy.R
import com.zhalz.eventy.databinding.ActivityMainBinding
import com.zhalz.eventy.utils.setStatusBarColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : NoViewModelActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val appBarConfiguration by lazy {
        AppBarConfiguration(setOf(R.id.nav_home, R.id.nav_history, R.id.nav_notif), binding.drawerLayout)
    }

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStatusBarColor(TRANSPARENT)

        binding.activity = this

        setDrawer()

        binding.bottomNav.setupWithNavController(navController)
    }

    private fun setDrawer() {
        setSupportActionBar(binding.toolbar)

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_contact -> navController.navigate(R.id.nav_contact)
                R.id.menu_help -> tos("HELP")
                R.id.menu_logout -> tos("LOGOUT")
            }
            binding.drawerLayout.closeDrawers()
            true
        }
    }

    override fun onSupportNavigateUp() =
        navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

}