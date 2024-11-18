package com.zhalz.eventy.presentation.main

import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.crocodic.core.base.activity.NoViewModelActivity
import com.crocodic.core.extension.openActivity
import com.crocodic.core.extension.tos
import com.zhalz.eventy.R
import com.zhalz.eventy.databinding.ActivityMainBinding
import com.zhalz.eventy.databinding.NavHeaderBinding
import com.zhalz.eventy.domain.model.Person
import com.zhalz.eventy.presentation.profile.ProfileActivity
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_PERSON
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

    private val user by lazy {
        Person(1234567, "Faishal Mukhammad", "faishalmukhammadsyarief@gmail.com", "081313327023", "Faishal Mukhammad Syarief", "_zhalz_", "faishall")
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

        val header = binding.navView.getHeaderView(0)
        DataBindingUtil.bind<NavHeaderBinding>(header)?.apply {
            person = user
            root.setOnClickListener { openActivity<ProfileActivity> { putExtra(EXTRA_PERSON, user) } }
        }

    }

    fun toProfile() = openActivity<ProfileActivity> { putExtra(EXTRA_PERSON, user) }

    override fun onSupportNavigateUp() =
        navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

}