package com.zhalz.eventy.base

import android.app.Application
import com.crocodic.core.helper.tree.ReleaseTree
import com.zhalz.eventy.BuildConfig.DEBUG
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        if (DEBUG) Timber.plant(Timber.DebugTree())
        else Timber.plant(ReleaseTree())
    }

}