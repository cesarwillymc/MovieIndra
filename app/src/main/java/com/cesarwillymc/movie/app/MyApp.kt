package com.cesarwillymc.movie.app

import android.app.Application
import android.content.Context
import com.cesarwillymc.movie.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {
    companion object {
        private lateinit var instance: MyApp
        fun getContextApp(): Context = instance
        fun setInstance(instance: MyApp) {
            this.instance = instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        setInstance(this)
        initDependencyInjection()
    }

    private fun initDependencyInjection() {
        //Init koin dependency injection
        startKoin {
            // Koin Android logger
            androidLogger()

            //inject Android context
            androidContext(this@MyApp)
            // use modules
            modules(module(override = true) {

                modules(repoModule + useCaseModule + dbModule + networkModule + viewModelModule)
            })
        }
    }

}