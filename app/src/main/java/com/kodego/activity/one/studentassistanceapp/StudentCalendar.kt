package com.kodego.activity.one.studentassistanceapp

import android.content.ContentUris
import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityStudentAppHomeScreenBinding
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityStudentCalendarBinding
import java.util.*


class StudentCalendar : AppCompatActivity() {
    lateinit var binding: ActivityStudentCalendarBinding

    // on below line we are creating
    // variables for text view and calendar view
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView
    val insertCalendarIntent = Intent(Intent.ACTION_INSERT)
        .setData(CalendarContract.Events.CONTENT_URI)
    val RECURRENCE_RULE = "FREQ=WEEKLY;BYDAY=MO"
    val EVENT_BEGIN_TIME_IN_MILLIS = Calendar.getInstance().timeInMillis
//    val EVENT_END_TIME_IN_MILLIS = Calendar.getInstance().add(Calendar.HOUR_OF_DAY, 2).timeInMillis


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddSchedule.setOnClickListener() {
            Toast.makeText(applicationContext, "Opening event scheduler...", Toast.LENGTH_SHORT)
                .show()

//            val insertCalendarIntent = Intent(Intent.ACTION_INSERT)
//                .setData(CalendarContract.Events.CONTENT_URI)
//                .putExtra(CalendarContract.Events.TITLE, "TITLE") // Simple title
//                .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false)
//                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,startCalendarInstance) // Only date part is considered when ALL_DAY is true; Same as DTSTART
//                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME) // Only date part is considered when ALL_DAY is true
//                .putExtra(CalendarContract.Events.EVENT_LOCATION, "Hong Kong")
//                .putExtra(CalendarContract.Events.DESCRIPTION, "DESCRIPTION") // Description
//                .putExtra(Intent.EXTRA_EMAIL, "fooInviteeOne@gmail.com,fooInviteeTwo@gmail.com")
//                .putExtra(CalendarContract.Events.RRULE, getRRule()) // Recurrence rule
//                .putExtra(CalendarContract.Events.ACCESS_LEVEL, CalendarContract.Events.ACCESS_PRIVATE)
//                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_FREE)
//            startActivity(insertCalendarIntent)

//        val insertCalendarIntent = Intent(Intent.ACTION_INSERT)
//            .setData(CalendarContract.Events.CONTENT_URI)
//            .putExtra(... , ...)
//        startActivity(insertCalendarIntent)

            //>>> IMPORTANT: THIS WILL OPEN GOOGLE CALENDAR
            val CALENDAR_EVENT_TIME = 1546300800000 // 2019-01-01 00:00:00

// Part 1: URI construction
            val builder = CalendarContract.CONTENT_URI.buildUpon().appendPath("time")
            ContentUris.appendId(builder, CALENDAR_EVENT_TIME)
            val uri = builder.build() // Log: content://com.android.calendar/time/1546300800000

// Part 2: Set Intent action to Intent.ACTION_VIEW
            val intent = Intent(Intent.ACTION_VIEW)
                .setData(uri)
            startActivity(intent)


//        // initializing variables of
//        // list view with their ids.
        dateTV = findViewById(R.id.idTVDate)
        calendarView = findViewById(R.id.calendarView)
//
        // on below line we are adding set on
        // date change listener for calendar view.
        calendarView
            .setOnDateChangeListener(
                CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
                    // In this Listener we are getting values
                    // such as year, month and day of month
                    // on below line we are creating a variable
                    // in which we are adding all the variables in it.
                    val Date = (dayOfMonth.toString() + "-"
                            + (month + 1) + "-" + year)

                    // set this date in TextView for Display
                    dateTV.setText(Date)
                })


        }
    }

    fun getEventIdList(): ArrayList<Long> {
        val eventIdList = ArrayList<Long>()

        val EVENT_PROJECTION: Array<String> = arrayOf(
            CalendarContract.Events._ID, // 0
            CalendarContract.Events.TITLE  // 1
        )
        val PROJECTION_EVENT_ID_INDEX: Int = 0
        val PROJECTION_TITLE_INDEX: Int = 1

        contentResolver.query(
            CalendarContract.Events.CONTENT_URI,
            EVENT_PROJECTION,
            "",
            arrayOf(),
            null
        )?.let {
            while (it.moveToNext() ?: false) {
                // Get the field values
                val eventId = it.getLong(PROJECTION_EVENT_ID_INDEX)
                val title = it.getString(PROJECTION_TITLE_INDEX)
                eventIdList.add(eventId)
            }
        }
        return eventIdList
    }
}