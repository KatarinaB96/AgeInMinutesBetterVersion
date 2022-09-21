package com.tutorials.ageinminutesbetterversion.di.activity

import com.tutorials.ageinminutesbetterversion.base.BaseActivity
import com.tutorials.ageinminutesbetterversion.di.activity.module.ActivityModule
import com.tutorials.ageinminutesbetterversion.di.activity.module.ActivityViewModelModule
import com.tutorials.ageinminutesbetterversion.di.application.ApplicationComponent
import com.tutorials.ageinminutesbetterversion.di.scopes.ActivityScope
import dagger.Component


@ActivityScope
@Component(
    dependencies = [(ApplicationComponent::class)],
    modules = [ActivityModule::class,
        ActivityViewModelModule::class]
)

interface ActivityComponent :ActivityComponentInjects, ActivityComponentExposes {
    object Initializer {
        fun init(
            baseActivity: BaseActivity,
            applicationComponent: ApplicationComponent
        ): ActivityComponent =
            DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(ActivityModule(baseActivity))
                .activityViewModelModule(ActivityViewModelModule(baseActivity))
                .build()
    }
}