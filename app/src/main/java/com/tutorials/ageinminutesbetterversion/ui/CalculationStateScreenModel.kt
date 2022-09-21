package com.tutorials.ageinminutesbetterversion.ui

import androidx.annotation.StringRes

sealed class CalculationStateScreenModel {
    data class ShowWrongDateToast(@StringRes val messageId: Int) : CalculationStateScreenModel()
    data class ShowDateDialog(@StringRes val messageId: Int, val result: Long, val date: String) : CalculationStateScreenModel()
}
