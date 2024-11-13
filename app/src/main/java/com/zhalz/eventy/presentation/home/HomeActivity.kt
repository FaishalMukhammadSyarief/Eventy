package com.zhalz.eventy.presentation.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.crocodic.core.base.activity.NoViewModelActivity
import com.crocodic.core.extension.tos
import com.zhalz.eventy.R
import com.zhalz.eventy.databinding.ActivityHomeBinding

class HomeActivity : NoViewModelActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private val appBarConfiguration by lazy { AppBarConfiguration(
        setOf( R.id.nav_contact ),
        binding.drawerLayout
    ) }

    private val navController by lazy { findNavController(R.id.nav_host) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

        setSupportActionBar(binding.toolbar)

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
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