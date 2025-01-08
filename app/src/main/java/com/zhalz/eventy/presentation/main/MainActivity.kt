package com.zhalz.eventy.presentation.main

import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
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
import com.zhalz.eventy.presentation.create_event.CreateEventActivity
import com.zhalz.eventy.presentation.landing.LandingActivity
import com.zhalz.eventy.presentation.profile.ProfileActivity
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_PERSON
import com.zhalz.eventy.utils.fadeIn
import com.zhalz.eventy.utils.fadeOut
import com.zhalz.eventy.utils.getWindowBackgroundColor
import com.zhalz.eventy.utils.gone
import com.zhalz.eventy.utils.setStatusBarColor
import com.zhalz.eventy.utils.slideDown
import com.zhalz.eventy.utils.slideUp
import com.zhalz.eventy.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : NoViewModelActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val appBarConfiguration by lazy {
        AppBarConfiguration(setOf(R.id.home_fragment, R.id.nav_history, R.id.nav_notif), binding.drawerLayout)
    }

    private val navController by lazy {
        binding.navHost.getFragment<NavHostFragment>().navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColor(getWindowBackgroundColor())

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
                R.id.nav_contact -> navController.navigate(R.id.nav_contact)
                R.id.menu_help -> tos("HELP")
                R.id.menu_logout -> openActivity<LandingActivity> { finishAffinity() }
            }
            binding.drawerLayout.closeDrawers()
            true
        }

        binding.drawerLayout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) = setStatusBarColor(TRANSPARENT)

            override fun onDrawerClosed(drawerView: View) = setStatusBarColor(getWindowBackgroundColor())
        })

    }

    private fun setBottomNav() {
        binding.bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.event_fragment -> binding.apply {
                    bottomApp.slideDown()
                    fabCreate.fadeOut()
                    ivProfile.gone()
                }
                else -> binding.apply {
                    if (bottomApp.translationY != 0f) bottomApp.slideUp()
                    if (fabCreate.alpha == 0f) fabCreate.fadeIn()
                    ivProfile.visible()
                }
            }
        }
    }

    fun setToolbarTitle(title: String) = binding.toolbar.setTitle(title)

    fun toProfile() = openActivity<ProfileActivity> { putExtra(EXTRA_PERSON, user) }
    fun toCreate() = openActivity<CreateEventActivity>()

    override fun onSupportNavigateUp() =
        navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

}