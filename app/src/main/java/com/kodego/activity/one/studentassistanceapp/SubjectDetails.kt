package com.kodego.activity.one.studentassistanceapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.kodego.activity.one.studentassistanceapp.databinding.ActivitySubjectDetailsBinding
import com.kodego.activity.one.studentassistanceapp.fragments.Assignment2Fragment
import com.kodego.activity.one.studentassistanceapp.view.AnnouncemntFragment
import com.kodego.activity.one.studentassistanceapp.view.NotesFragment
import com.kodego.activity.one.studentassistanceapp.view.SubjectFragment
import com.kodego.activity.one.studentassistanceapp.view.SyllabusFragment

//holder of assignment and other fragments:
class SubjectDetails : AppCompatActivity() {

    lateinit var binding: ActivitySubjectDetailsBinding
    private val fragmentManger = supportFragmentManager
    private val subjectFrag = SubjectFragment()
    private val assignmentFrag = Assignment2Fragment()
    private val notesFrag = NotesFragment()
    private val announcementFrag = AnnouncemntFragment()
    private val syllabusFrag = SyllabusFragment()

    /**call id*/
    private lateinit var btnSubject: ImageButton
    private lateinit var btnAssignment: ImageButton
    private lateinit var btnNotes: ImageButton
    private lateinit var btnAnnouncement: ImageButton
    private lateinit var btnSyllabus: ImageButton

    private lateinit var manger: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //do this in fragments
        binding = ActivitySubjectDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**set find id view*/
//        removed the subject details fragment

//        binding.assignments
        btnAssignment = findViewById(R.id.assignments)
//        binding.notes
        btnNotes = findViewById(R.id.notes)
//        binding.announcements
        btnAnnouncement = findViewById(R.id.announcements)
//        binding.syllabus
        btnSyllabus = findViewById(R.id.syllabus)

        /**set the First Fragment*/
        manger = fragmentManger.beginTransaction()
            .replace(R.id.myView,assignmentFrag)
        manger.commit()
        btnAssignment.setImageResource(R.drawable.ic_pink_assignment_24)


    }

    fun addFragOnClick(view: View) {

        /**set replace fragment*/
        manger = fragmentManger.beginTransaction()
        when(view){
            btnAssignment -> {
//                Toast.makeText(applicationContext, "Assignments", Toast.LENGTH_SHORT).show()
                manger.replace(R.id.myView,assignmentFrag)
                    .commit()
                btnAssignment.setImageResource(R.drawable.ic_pink_assignment_24)
                btnNotes.setImageResource(R.drawable.ic_blue_notes_24)
                btnAnnouncement.setImageResource(R.drawable.ic_announce_blu_24)
                btnSyllabus.setImageResource(R.drawable.ic_baseline_list_alt_24)
            }
            btnSyllabus -> {
//                Toast.makeText(applicationContext, "Syllabus", Toast.LENGTH_SHORT).show()
                manger.replace(R.id.myView,syllabusFrag)
                    .commit()
                btnAssignment.setImageResource(R.drawable.ic_baseline_assignment_24)
                btnNotes.setImageResource(R.drawable.ic_blue_notes_24)
                btnAnnouncement.setImageResource(R.drawable.ic_announce_blu_24)
                btnSyllabus.setImageResource(R.drawable.ic_pink_syllabus_24)
            }
            btnNotes -> {
//                Toast.makeText(applicationContext, "Notes", Toast.LENGTH_SHORT).show()
                manger.replace(R.id.myView,notesFrag)
                    .commit()
                btnAssignment.setImageResource(R.drawable.ic_baseline_assignment_24)
                btnNotes.setImageResource(R.drawable.ic_pink_notes_24)
                btnAnnouncement.setImageResource(R.drawable.ic_announce_blu_24)
                btnSyllabus.setImageResource(R.drawable.ic_baseline_list_alt_24)
            }
            btnAnnouncement -> {
//                Toast.makeText(applicationContext, "Announcements", Toast.LENGTH_SHORT).show()
                manger.replace(R.id.myView,announcementFrag)
                    .commit()
                btnAssignment.setImageResource(R.drawable.ic_baseline_assignment_24)
                btnNotes.setImageResource(R.drawable.ic_blue_notes_24)
                btnAnnouncement.setImageResource(R.drawable.ic_pink_announcement_24)
                btnSyllabus.setImageResource(R.drawable.ic_baseline_list_alt_24)
            }
        }
    }




}