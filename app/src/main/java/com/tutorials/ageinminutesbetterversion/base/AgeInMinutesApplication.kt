package com.tutorials.ageinminutesbetterversion.base

import android.app.Application
import android.content.Context
import com.tutorials.ageinminutesbetterversion.ComponentFactory
import com.tutorials.ageinminutesbetterversion.di.application.ApplicationComponent

class AgeInMinutesApplication : Application() {
    private lateinit var applicationComponent: ApplicationComponent

    companion object {
        fun from(context: Context): AgeInMinutesApplication {
            return context.applicationContext as AgeInMinutesApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = ComponentFactory.createApplicationComponent(this)
        applicationComponent.inject(this)
    }

    fun getApplicationComponent() = applicationComponent
}