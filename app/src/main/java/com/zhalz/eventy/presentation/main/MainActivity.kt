package com.zhalz.eventy.presentation.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
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
import com.zhalz.eventy.data.user
import com.zhalz.eventy.databinding.ActivityMainBinding
import com.zhalz.eventy.databinding.NavHeaderBinding
import com.zhalz.eventy.presentation.auth.landing.LandingActivity
import com.zhalz.eventy.presentation.create_event.CreateEventActivity
import com.zhalz.eventy.presentation.profile.ProfileActivity
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_PERSON
import com.zhalz.eventy.utils.extension.fadeIn
import com.zhalz.eventy.utils.extension.fadeOut
import com.zhalz.eventy.utils.extension.gone
import com.zhalz.eventy.utils.extension.slideDown
import com.zhalz.eventy.utils.extension.slideUp
import com.zhalz.eventy.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : NoViewModelActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val appBarConfiguration by lazy {
        AppBarConfiguration(setOf(R.id.home_fragment, R.id.history_fragment, R.id.notification_fragment), binding.drawerLayout)
    }

    private val navController by lazy {
        binding.navHost.getFragment<NavHostFragment>().navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

        setActionbar()
        setDrawer()
        setBottomNav()
    }

    private fun setActionbar() {
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun setDrawer() {
        val header = binding.navView.getHeaderView(0)
        DataBindingUtil.bind<NavHeaderBinding>(header)?.apply {
            person = user
            root.setOnClickListener { openActivity<ProfileActivity> { putExtra(EXTRA_PERSON, user) } }
        }

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.contact_fragment -> navController.navigate(R.id.action_home_to_contact)
                R.id.menu_help -> tos("HELP")
                R.id.menu_logout -> openActivity<LandingActivity> { finishAffinity() }
            }
            binding.drawerLayout.closeDrawers()
            true
        }
    }

    private fun setBottomNav() {
        binding.bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.home_fragment -> binding.apply {
                    if (bottomApp.translationY != 0f) bottomApp.slideUp()
                    if (fabCreate.alpha == 0f) fabCreate.fadeIn()
                    ivProfile.visible()
                }
                R.id.history_fragment -> binding.apply {
                    if (bottomApp.translationY != 0f) bottomApp.slideUp()
                    if (fabCreate.alpha == 0f) fabCreate.fadeIn()
                    ivProfile.visible()
                }
                R.id.notification_fragment -> binding.apply {
                    if (bottomApp.translationY != 0f) bottomApp.slideUp()
                    if (fabCreate.alpha == 0f) fabCreate.fadeIn()
                    ivProfile.visible()
                }
                else -> binding.apply {
                    bottomApp.slideDown()
                    fabCreate.fadeOut()
                    ivProfile.gone()
                }
            }
        }
    }

    fun toProfile() = openActivity<ProfileActivity> { putExtra(EXTRA_PERSON, user) }
    fun toCreate() = openActivity<CreateEventActivity>()

    override fun onSupportNavigateUp() =
        navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

}