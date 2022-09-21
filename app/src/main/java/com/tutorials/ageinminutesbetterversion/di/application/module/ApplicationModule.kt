package com.tutorials.ageinminutesbetterversion.di.application.module

import android.content.Context
import com.tutorials.ageinminutesbetterversion.base.AgeInMinutesApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val ageApplication: AgeInMinutesApplication) {

    @Provides
    @Singleton
    internal fun provideAgeApplication(): AgeInMinutesApplication {
        return ageApplication
    }

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return ageApplication
    }

    interface Exposes {
        fun ageApplication(): AgeInMinutesApplication
        fun context(): Context
    }
}