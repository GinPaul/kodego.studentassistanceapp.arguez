package com.kodego.activity.one.studentassistanceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kodego.activity.one.studentassistanceapp.databinding.ActivitySubjectDetails2Binding
import com.kodego.activity.one.studentassistanceapp.view.*

class SubjectDetails2 : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectDetails2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectDetails2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val subjectFrag = SubjectFragment2()
        val assignmentFrag = AssignmentFragment2()
        val notesFrag = NotesFragment2()
        val announcementFrag = AnnouncementFragment2()
        val syllabusFrag = SyllabusFragment2()

        /**initial fragment*/
        supportFragmentManager.beginTransaction().apply {
            replace(binding.myMainFrag2.id, subjectFrag)
            commit()
        }

        binding.subjectDetails2.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(binding.myMainFrag2.id, subjectFrag)
                commit()
            }
        }

        binding.assignments2.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply{
                replace(binding.myMainFrag2.id, assignmentFrag)
                commit()
            }
        }
        binding.notes2.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.myMainFrag2.id, notesFrag)
                commit()
            }
        }
        binding.announcements2.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.myMainFrag2.id, announcementFrag)
                commit()
            }
        }
        binding.syllabus2.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.myMainFrag2.id, syllabusFrag)
                commit()
            }
        }


    }
}