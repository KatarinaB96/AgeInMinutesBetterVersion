package com.tutorials.ageinminutesbetterversion.di.activity.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.tutorials.ageinminutesbetterversion.base.BaseActivity
import com.tutorials.ageinminutesbetterversion.ui.AgeViewModel
import com.tutorials.ageinminutesbetterversion.ui.AgeViewModelImpl
import com.tutorials.ageinminutesbetterversion.ui.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class ActivityViewModelModule(private val baseActivity: BaseActivity) {
    @Provides
    internal fun provideViewModel(): AgeViewModel {
        return ViewModelProvider(baseActivity, ViewModelProviderFactory(AgeViewModelImpl::class) {
            AgeViewModelImpl()
        })[AgeViewModelImpl::class.java]
    }

    interface Exposes {
        fun ageViewModel(): AgeViewModel
    }
}