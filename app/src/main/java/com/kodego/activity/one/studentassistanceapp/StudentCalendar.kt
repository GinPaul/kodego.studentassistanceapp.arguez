package com.kodego.activity.one.studentassistanceapp

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityStudentCalendarBinding
import java.util.*


class StudentCalendar : AppCompatActivity() {
    lateinit var binding: ActivityStudentCalendarBinding

    // variables for text view and calendar view
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView
    val insertCalendarIntent = Intent(Intent.ACTION_INSERT)
        .setData(CalendarContract.Events.CONTENT_URI)
    val RECURRENCE_RULE = "FREQ=WEEKLY;BYDAY=MO"
    val EVENT_BEGIN_TIME_IN_MILLIS = Calendar.getInstance().timeInMillis

    //    val EVENT_END_TIME_IN_MILLIS = Calendar.getInstance().add(Calendar.HOUR_OF_DAY, 2).timeInMillis
    val REQUEST_CODE_ADD_CALENDAR = 111

//    // Projection array. Creating indices for this array instead of doing
//    // dynamic lookups improves performance.
//    private val EVENT_PROJECTION: Array<String> = arrayOf(
//        CalendarContract.Calendars._ID,                     // 0
//        CalendarContract.Calendars.ACCOUNT_NAME,            // 1
//        CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,   // 2
//        CalendarContract.Calendars.OWNER_ACCOUNT            // 3
//    )
//
//    // The indices for the projection array above.
//    private val PROJECTION_ID_INDEX: Int = 0
//    private val PROJECTION_ACCOUNT_NAME_INDEX: Int = 1
//    private val PROJECTION_DISPLAY_NAME_INDEX: Int = 2
//    private val PROJECTION_OWNER_ACCOUNT_INDEX: Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddSchedule.setOnClickListener() {
            Toast.makeText(applicationContext, "Opening event scheduler...", Toast.LENGTH_SHORT)
                .show()
            addCalendarEvent(binding.root)
//
//            // Run query
//            val uri: Uri = CalendarContract.Calendars.CONTENT_URI
//            val selection: String = "((${CalendarContract.Calendars.ACCOUNT_NAME} = ?) AND (" +
//                    "${CalendarContract.Calendars.ACCOUNT_TYPE} = ?) AND (" +
//                    "${CalendarContract.Calendars.OWNER_ACCOUNT} = ?))"
//            val selectionArgs: Array<String> = arrayOf("hera@example.com", "com.example", "hera@example.com")
//            val cur: Cursor? = contentResolver.query(uri, EVENT_PROJECTION, selection, selectionArgs, null)
//
//            val DEBUG_TAG: String = "MyActivity"
//            val calID: Long = 2
//            val values = ContentValues().apply {
//                // The new display name for the calendar
//                put(CalendarContract.Calendars.CALENDAR_DISPLAY_NAME, "Trevor's Calendar")
//            }
//            val updateUri: Uri = ContentUris.withAppendedId(CalendarContract.Calendars.CONTENT_URI, calID)
//            val rows: Int = contentResolver.update(updateUri, values, null, null)
//            Log.i(DEBUG_TAG, "Rows updated: $rows")


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

//            //>>> IMPORTANT: THIS WILL OPEN GOOGLE CALENDAR
//            val CALENDAR_EVENT_TIME = 1666668754000 // 2019-01-01 00:00:00
//
//// Part 1: URI construction
//            val builder = CalendarContract.CONTENT_URI.buildUpon().appendPath("time")
//            ContentUris.appendId(builder, CALENDAR_EVENT_TIME)
//            val uri = builder.build() // Log: content://com.android.calendar/time/1546300800000
//
//// Part 2: Set Intent action to Intent.ACTION_VIEW
//            val intent = Intent(Intent.ACTION_VIEW)
//                .setData(uri)
//            startActivity(intent)

        }


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
    }
}



