package com.tutorials.ageinminutesbetterversion.ui

import androidx.lifecycle.MutableLiveData

interface AgeViewModel {
    fun calculateAge(dayOfMonth: Int, monthOfYear: Int, year: Int)
    val ages: MutableLiveData<CalculationStateScreenModel>

}