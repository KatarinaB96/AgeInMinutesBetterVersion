package com.tutorials.ageinminutesbetterversion.ui

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import com.tutorials.ageinminutesbetterversion.R
import com.tutorials.ageinminutesbetterversion.base.BaseActivity
import com.tutorials.ageinminutesbetterversion.databinding.ActivityMainBinding
import com.tutorials.ageinminutesbetterversion.di.activity.ActivityComponent
import java.util.*
import javax.inject.Inject


class MainActivity : BaseActivity() {


    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var ageViewModel: AgeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultOfCalculation()
        observeData()

        supportActionBar?.title = getString(R.string.action_bar_title)
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    private fun resultOfCalculation() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        binding.selectDate.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    ageViewModel.calculateAge(dayOfMonth, monthOfYear, year)
                },
                year, month, day
            )
            datePickerDialog.show()
        }
    }

    private fun observeData() {
        ageViewModel.ages.observe(this) {

            when (it) {
                is CalculationStateScreenModel.ShowWrongDateToast -> showPickedWrongDateToast(it.messageId)
                is CalculationStateScreenModel.ShowDateDialog -> showCalculatedAgeDialog(
                    it.result,
                    it.date,
                    it.messageId
                )
            }
        }
    }

    private fun showPickedWrongDateToast(message: Int) {

        Toast.makeText(this, getString(message), Toast.LENGTH_LONG).show()

        binding.pickedDate.text = ""
        binding.ageInMinutes.text = ""
    }

    private fun showCalculatedAgeDialog(result: Long, date: String, message: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(message))
        builder.setPositiveButton(getString(R.string.age_dialog_positive_text)) { dialog, which ->
            dialog.dismiss()
        }

        builder.setMessage("${result}")
        val dialog = builder.create()
        dialog.show()
        dialog.setCancelable(true)

        val b = dialog.getButton(DialogInterface.BUTTON_POSITIVE)
        if (b != null) {
            b.setTextColor(R.drawable.button)
        }

        binding.ageInMinutes.text = result.toString()
        binding.pickedDate.text = date
    }


}
