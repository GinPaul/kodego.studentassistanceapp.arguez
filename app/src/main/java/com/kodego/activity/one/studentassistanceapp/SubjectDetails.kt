package com.kodego.activity.one.studentassistanceapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.kodego.activity.one.studentassistanceapp.databinding.ActivitySubjectDetailsBinding
import com.kodego.activity.one.studentassistanceapp.view.*

class SubjectDetails : AppCompatActivity() {

    lateinit var binding: ActivitySubjectDetailsBinding
    private val fragmentManger = supportFragmentManager
    private val subjectFrag = SubjectFragment()
    private val assignmentFrag = AssignmentFragment()
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
//        binding.subjectDetails.setOnClickListener(){
//
//        }
        
        btnSubject = findViewById(R.id.subjectDetails)
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
            .replace(R.id.myView,subjectFrag)
        manger.commit()
        btnSubject.setImageResource(R.drawable.ic_pink_subject)


//        //data from home activity
        var subjectName: String? = intent.getStringExtra("subjectName") //>>need to add "?" to accept null inputs/values
        var subjectDescription : String? = intent.getStringExtra("subjectDescription")
        var imageSubject: Int = intent.getIntExtra("imageSubject",0)
////        var quantity: Int = intent.getIntExtra("quantity",0)

        //passing data to fragment 1 (subject frag)
        var bundleSubjectDetails = Bundle()
        bundleSubjectDetails.putString("subjectName", subjectName)
        subjectFrag.arguments = bundleSubjectDetails

        var bundleSubjectDescription = Bundle()
        bundleSubjectDescription.putString("subjectDescription", subjectDescription)
        subjectFrag.arguments = bundleSubjectDescription

        var bundleSubjectImage = Bundle()
        bundleSubjectImage.putInt("imageSubject", imageSubject)
        subjectFrag.arguments = bundleSubjectImage

        //pass the data to Subject Details view upon click in the recycler view of home activity
//        binding.imgOfSubjectInSubjectDetailsView.setImageResource(imageSubject)
//        binding.tvSubject.text = subjectName
//        binding.tvDescriptionInSubjectDetailsView2.text = subjectDescription


    }

    fun addFragOnClick(view: View) {

        /**set replace fragment*/
        manger = fragmentManger.beginTransaction()
        when(view){
            btnSubject -> {
//                Toast.makeText(applicationContext, "Subject details", Toast.LENGTH_SHORT).show()
                manger.replace(R.id.myView,subjectFrag)
                    .commit()
                btnSubject.setImageResource(R.drawable.ic_pink_subject)
                btnAssignment.setImageResource(R.drawable.ic_baseline_assignment_24)
                btnNotes.setImageResource(R.drawable.ic_blue_notes_24)
                btnAnnouncement.setImageResource(R.drawable.ic_announce_blu_24)
                btnSyllabus.setImageResource(R.drawable.ic_baseline_list_alt_24)
            }
            btnSyllabus -> {
//                Toast.makeText(applicationContext, "Syllabus", Toast.LENGTH_SHORT).show()
                manger.replace(R.id.myView,syllabusFrag)
                    .commit()
                btnSubject.setImageResource(R.drawable.ic_subject_book_24)
                btnAssignment.setImageResource(R.drawable.ic_baseline_assignment_24)
                btnNotes.setImageResource(R.drawable.ic_blue_notes_24)
                btnAnnouncement.setImageResource(R.drawable.ic_announce_blu_24)
                btnSyllabus.setImageResource(R.drawable.ic_pink_syllabus_24)
            }
            btnAssignment -> {
//                Toast.makeText(applicationContext, "Assignments", Toast.LENGTH_SHORT).show()
                manger.replace(R.id.myView,assignmentFrag)
                    .commit()
                btnSubject.setImageResource(R.drawable.ic_subject_book_24)
                btnAssignment.setImageResource(R.drawable.ic_pink_assignment_24)
                btnNotes.setImageResource(R.drawable.ic_blue_notes_24)
                btnAnnouncement.setImageResource(R.drawable.ic_announce_blu_24)
                btnSyllabus.setImageResource(R.drawable.ic_baseline_list_alt_24)
            }
            btnNotes -> {
//                Toast.makeText(applicationContext, "Notes", Toast.LENGTH_SHORT).show()
                manger.replace(R.id.myView,notesFrag)
                    .commit()
                btnSubject.setImageResource(R.drawable.ic_subject_book_24)
                btnAssignment.setImageResource(R.drawable.ic_baseline_assignment_24)
                btnNotes.setImageResource(R.drawable.ic_pink_notes_24)
                btnAnnouncement.setImageResource(R.drawable.ic_announce_blu_24)
                btnSyllabus.setImageResource(R.drawable.ic_baseline_list_alt_24)
            }
            btnAnnouncement -> {
//                Toast.makeText(applicationContext, "Announcements", Toast.LENGTH_SHORT).show()
                manger.replace(R.id.myView,announcementFrag)
                    .commit()
                btnSubject.setImageResource(R.drawable.ic_subject_book_24)
                btnAssignment.setImageResource(R.drawable.ic_baseline_assignment_24)
                btnNotes.setImageResource(R.drawable.ic_blue_notes_24)
                btnAnnouncement.setImageResource(R.drawable.ic_pink_announcement_24)
                btnSyllabus.setImageResource(R.drawable.ic_baseline_list_alt_24)
            }
        }
    }


}