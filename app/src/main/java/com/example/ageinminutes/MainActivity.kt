package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)
        var textView1 = findViewById<TextView>(R.id.textView1)
        var textView2 = findViewById<TextView>(R.id.textView2)
        button.setOnClickListener {

            button.setOnClickListener { view ->
                clickDatePicker(view)
            }
        }
    }


    fun clickDatePicker(view: View) {

        //to fetch current date
        val myCalendar = Calendar.getInstance()  //object create
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)



        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay_Of_Month -> //user selected values(received values)
                val selectedDate = "$selectedDay_Of_Month/${selectedMonth+1}/$selectedYear"
                textView1.text=selectedDate




                var dob= Calendar.getInstance()
                dob.set( selectedYear, selectedMonth, selectedDay_Of_Month)

                //age calculation in years
                var age= myCalendar.get(Calendar.YEAR)-dob.get(Calendar.YEAR)
                //current year-user's dob

                if(myCalendar.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
                {
                    age--
                }
                textView2.text="Your Age is $age "


            }, year, month, day
        ).show()


    }
}