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

                Toast.makeText(this, "Enjoy Your Day",Toast.LENGTH_LONG).show()

                val selectedDate = " $SelectedDay/${SelectedMonth+1}/$SelectedYear"

                tvdate.setText(selectedDate)
            tvselectedDate.text = "Selected Date"
                tvageInMinutes.text = "Age In Minutes"
            tvageInHour.text = "Age In Hour"
            tvageInDay.text = "Age In Days"

                val sdf = SimpleDateFormat("dd/MM/yyyy" , Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                val selectedDateInHours = theDate!!.time/3600000
                val selectedDateInMinutes = theDate.time/60000
            val selectedDateInD = theDate.time/86400000

                /*this above will give time in minutes,hour from 1jan 1970 to my selected date

              i am doing below code in one line which i made in 3 line above as in 36 ,40 ,42 */

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                //this will give time in millisecond from 1jan 1970

                val currentDateInHours = currentDate.time/3600000
                val currentDateInMinutes = currentDate.time /60000
            val currentDateInD = currentDate.time /86400000

                val differenceTimeInHours = currentDateInHours - selectedDateInHours
                val differenceTimeInMinutes = currentDateInMinutes - selectedDateInMinutes
            val differenceTimeInD = currentDateInD - selectedDateInD

                DateInHour.setText(differenceTimeInHours.toString())
                DateInMinute.setText(differenceTimeInMinutes.toString())
            DateInDay.setText(differenceTimeInD.toString())


                },year , month, day)

        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()

            }

}