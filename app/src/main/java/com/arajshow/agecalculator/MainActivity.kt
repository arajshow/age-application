package com.arajshow.agecalculator

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


//hi there, i am making my first project
//see you soon
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDatePiker.setOnClickListener {view ->
            clickDatePikker(view)
             }
        }

    @SuppressLint("SetTextI18n")
    fun clickDatePikker(view : View){

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                    view, SelectedYear, SelectedMonth, SelectedDay ->

                Toast.makeText(this, "thanks for using this\uD83C\uDF1A",Toast.LENGTH_LONG).show()

                val selectedDate = " $SelectedDay/${SelectedMonth+1}/$SelectedYear"

                tvdate.setText(selectedDate)
            tvselectedDate.text = "Selected Date"
                tvageInMinutes.text = "Age In Minutes"
            tvageInHour.text = "Age In Hours"

                val sdf = SimpleDateFormat("dd/MM/yyyy" , Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                val selectedDateInMinutes = theDate!!.time/60000
                val selectedDateInHours = theDate!!.time/3600000
                /*this above will give time in minutes,hour from 1jan 1970 to my selected date

              i am doing below code in one line which i made in 3 line above as in 36 ,40 ,42 */

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                //this will give time in millisecond from 1jan 1970

                val currentDateInMinutes = currentDate!!.time /60000
                val currentDateInHours = theDate!!.time/36000

                val differenceTimeInMinutes = currentDateInMinutes - selectedDateInMinutes
                val differenceTimeInHours = currentDateInHours - selectedDateInHours

                DateInMinute.setText(differenceTimeInMinutes.toString())
                DateInHour.setText(differenceTimeInHours.toString())

                },year , month, day)

        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()

            }

}