package com.tutorials.ageinminutesbetterversion.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tutorials.ageinminutesbetterversion.Constants
import com.tutorials.ageinminutesbetterversion.R
import java.text.SimpleDateFormat
import java.util.*


class AgeViewModelImpl : AgeViewModel, ViewModel() {

    override val ages: MutableLiveData<CalculationStateScreenModel> = MutableLiveData()

    override fun calculateAge(dayOfMonth: Int, monthOfYear: Int, year: Int) {

        val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
        val sdf = SimpleDateFormat(Constants.DATE_PATTERN, Locale.ENGLISH)
        val theDate = sdf.parse(selectedDate)

        theDate.let {
            val selectedDateInMinutes = (it?.time ?: 0) / Constants.MINUTES
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            currentDate.let {
                val currentDateToMinutes = (it?.time ?: 0) / Constants.MINUTES

                val result = if (dayOfMonth > 0 && monthOfYear + 1 > 0 && year > 0) {
                    (currentDateToMinutes - selectedDateInMinutes)
                } else {
                    0
                }

                val state = if (result > 0) {
                    CalculationStateScreenModel.ShowDateDialog(
                        R.string.dialog_title,
                        (currentDateToMinutes - selectedDateInMinutes),
                        selectedDate
                    )
                } else {
                    CalculationStateScreenModel.ShowWrongDateToast(
                        R.string.toast_message_wrong_date,
                    )
                }
                ages.postValue(state)
            }
        }
    }

}