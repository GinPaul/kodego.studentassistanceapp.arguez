package com.kodego.activity.one.studentassistanceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityLoginSav2Binding
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityStudentAppHomeScreenBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class StudentAppHomeScreen : AppCompatActivity() {

    //step 1: declare a lateinit variable
    lateinit var binding: ActivityStudentAppHomeScreenBinding
    lateinit var calendar: Calendar
    lateinit var simpleDateFormat: SimpleDateFormat
    lateinit var date: String
    lateinit var textView: TextView
    lateinit var buttong: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //step 2: declare binding variable with inflater
        binding = ActivityStudentAppHomeScreenBinding.inflate(layoutInflater)

        //step 3: change "R.layout.activity_student_app_home_screen" to "binding.root"
        setContentView(binding.root)


        //step 4: create functionality for the calendar/first button:
        binding.imgCalendarButton1.setOnClickListener() {
            Toast.makeText(applicationContext, "Opening calendar...", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, StudentCalendar::class.java)
            startActivity(intent)
        }

        textView = findViewById(R.id.tvDateToday)
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("MM-dd-yyyy")
        date = simpleDateFormat.format(calendar.time)
        textView.text = date

    }

    fun addCalendarEvent(view: View) {
        val calendarEvent: Calendar = Calendar.getInstance()
        val intent = Intent(Intent.ACTION_EDIT)
        intent.type = "vnd.android.cursor.item/event"
        intent.putExtra("beginTime", calendarEvent.timeInMillis)
        intent.putExtra("allDay", true)
        intent.putExtra("rule", "FREQ=YEARLY")
        intent.putExtra("endTime", calendarEvent.timeInMillis + 60 * 60 * 1000)
        intent.putExtra("title", "Calendar Event")
        startActivity(intent)



//            fun addCalendarEvent(view: View) {
//                val calendarEvent: Calendar = Calendar.getInstance()
//                val intent = Intent(Intent.ACTION_EDIT)
//                intent.type = "vnd.android.cursor.item/event"
//                intent.putExtra("beginTime", calendarEvent.timeInMillis)
//                intent.putExtra("allDay", true)
//                intent.putExtra("rule", "FREQ=YEARLY")
//                intent.putExtra("endTime", calendarEvent.timeInMillis + 60 * 60 * 1000)
//                intent.putExtra("title", "Calendar Event")
//                startActivity(intent)

        }


}