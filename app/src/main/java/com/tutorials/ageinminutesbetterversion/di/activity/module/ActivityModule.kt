package com.tutorials.ageinminutesbetterversion.di.activity.module

import android.app.Activity
import com.tutorials.ageinminutesbetterversion.base.BaseActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val baseActivity: BaseActivity) {

    @Provides
    internal fun provideActivity(): Activity {
        return baseActivity
    }


    interface Exposes {
        fun activity(): Activity
    }
}