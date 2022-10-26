package com.kodego.activity.one.studentassistanceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
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
    lateinit var button: Button
    lateinit var adapter: SubjectAdapter

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
        simpleDateFormat = SimpleDateFormat("EEE | MMM dd, yyyy")
        date = simpleDateFormat.format(calendar.time)
        textView.text = date


        //data source
        var subjectList: MutableList<Subjects> = mutableListOf<Subjects>(
            Subjects(R.drawable.flaskchemistry, 1, "Chemistry 17", "Introduction to Inorganic Chemistry"),
            Subjects(R.drawable.maths, 2, "Math 11", "Advanced Mathematics"),
            Subjects(R.drawable.atomphysics, 3, "Physics 21", "Quantum Physics"),
            Subjects(R.drawable.philosophy, 4, "Philosophy 1", "Philosophy"),
            Subjects(R.drawable.biologygene, 5, "Biology 2", "Molecular Biology"),
        )

        //pass data source to adapter (need lateinit var adapter)
        adapter = SubjectAdapter(subjectList)
        adapter.onItemClick = {
            Toast.makeText(applicationContext, it.subjectName, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SubjectDetails::class.java)
            intent.putExtra("subjectName", it.subjectName)
            intent.putExtra("subjectDescription", it.subjectDescription)
            intent.putExtra("imageSubject", it.imageSubject)
            intent.putExtra("subjectNumber", it.subjectNumber)
            startActivity(intent) //>>don't place "finish" so that the can go back the product list

        }

        binding.cvSubjectsRecylcer.adapter = adapter
        binding.cvSubjectsRecylcer.layoutManager = LinearLayoutManager(this)

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

//        fun addCalendarEvent(view: View) {
//            val calendarEvent: Calendar = Calendar.getInstance()
//            val intent = Intent(Intent.ACTION_EDIT)
//            intent.type = "vnd.android.cursor.item/event"
//            intent.putExtra("beginTime", calendarEvent.timeInMillis)
//            intent.putExtra("allDay", true)
//            intent.putExtra("rule", "FREQ=YEARLY")
//            intent.putExtra("endTime", calendarEvent.timeInMillis + 60 * 60 * 1000)
//            intent.putExtra("title", "Calendar Event")
//            startActivity(intent)

        }

}