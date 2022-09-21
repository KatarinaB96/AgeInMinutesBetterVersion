package com.tutorials.ageinminutesbetterversion.di.application

import com.tutorials.ageinminutesbetterversion.base.AgeInMinutesApplication
import com.tutorials.ageinminutesbetterversion.di.application.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class
    ]
)

interface ApplicationComponent:ApplicationComponentInjects,ApplicationComponentExposes {
    object Initializer {
        fun init(ageApplication: AgeInMinutesApplication): ApplicationComponent =
            DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(ageApplication))
                .build()
    }
}