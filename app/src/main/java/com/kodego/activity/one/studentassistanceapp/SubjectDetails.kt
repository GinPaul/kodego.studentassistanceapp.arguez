package com.kodego.activity.one.studentassistanceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kodego.activity.one.studentassistanceapp.databinding.ActivitySubjectDetailsBinding

class SubjectDetails : AppCompatActivity() {

    lateinit var binding: ActivitySubjectDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubjectDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //data from home activity
        var subjectName: String? = intent.getStringExtra("subjectName") //>>need to add "?" to accept null inputs/values
        var subjectDescription : String? = intent.getStringExtra("subjectDescription")
        var subjectImage: Int = intent.getIntExtra("imageSubject",0)
        var timeSlot: Int = intent.getIntExtra("timeSlot",0)
        var instructor: Int = intent.getIntExtra("instructor",0)


        binding.imgSubject2.setImageResource(subjectImage)
        binding.tvSubjectName2.text = subjectName
        binding.tvSubjectDescription2.text = subjectDescription
        binding.tvTimeSlot2.text = timeSlot.toString()
        binding.tvInstructor.text = timeSlot.toString()
    }



}