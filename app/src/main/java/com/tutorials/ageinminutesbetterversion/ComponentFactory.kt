package com.tutorials.ageinminutesbetterversion

import com.tutorials.ageinminutesbetterversion.base.AgeInMinutesApplication
import com.tutorials.ageinminutesbetterversion.base.BaseActivity
import com.tutorials.ageinminutesbetterversion.di.activity.ActivityComponent
import com.tutorials.ageinminutesbetterversion.di.application.ApplicationComponent

object ComponentFactory {
    fun createApplicationComponent(ageInMinutesApplication: AgeInMinutesApplication): ApplicationComponent {
        return ApplicationComponent.Initializer.init(ageInMinutesApplication)
    }

    fun createActivityComponent(baseActivity: BaseActivity, applicationComponent: ApplicationComponent):ActivityComponent{
        return ActivityComponent.Initializer.init(baseActivity,applicationComponent)
    }
}