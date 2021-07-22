package com.cesarwillymc.movie.app

import android.app.Application
import android.content.Context
import com.bugsnag.android.Bugsnag
import com.cesarwillymc.movie.module.*
import com.cesarwillymc.movie.module.module.ContextModule

class MyApp : Application() {
    lateinit var coreComponent: CoreComponent

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as? MyApp)?.coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initBugsnack()
        initCoreDependencyInjection()
        initAppDependencyInjection()

    }

    private fun initBugsnack() {
        Bugsnag.start(this)
    }

    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

    private fun initAppDependencyInjection() {
        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }

}