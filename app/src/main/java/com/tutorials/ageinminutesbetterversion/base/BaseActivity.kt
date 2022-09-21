package com.tutorials.ageinminutesbetterversion.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tutorials.ageinminutesbetterversion.ComponentFactory
import com.tutorials.ageinminutesbetterversion.di.activity.ActivityComponent

abstract class BaseActivity : AppCompatActivity() {
    private var activityComponent: ActivityComponent? = null

    private fun getAgeInMinutesApplication() = AgeInMinutesApplication.from(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(getActivityComponent())
    }

    fun getActivityComponent(): ActivityComponent {
        if (activityComponent == null) {
            activityComponent = ComponentFactory.createActivityComponent(
                this,
                getAgeInMinutesApplication().getApplicationComponent()
            )
        }
        return activityComponent as ActivityComponent
    }

    protected abstract fun inject(activityComponent: ActivityComponent)
}