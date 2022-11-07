package com.kodego.activity.one.studentassistanceapp

import androidx.appcompat.app.AppCompatActivity

class SubjectDetails : AppCompatActivity() {}
//
//    lateinit var binding: ActivitySubjectDetailsBinding
//    private val fragmentManger = supportFragmentManager
//    val subjectFrag = SubjectFragment()
//    val assignmentFrag = AssignmentFragment()
//    val notesFrag = NotesFragment()
//    val announcementFrag = AnnouncemntFragment()
//    val syllabusFrag = SyllabusFragment()
//
//    /**call id*/
//    private lateinit var btnSubject: ImageButton
//    private lateinit var btnAssignment: ImageButton
//    private lateinit var btnNotes: ImageButton
//    private lateinit var btnAnnouncement: ImageButton
//    private lateinit var btnSyllabus: ImageButton
//
//    private lateinit var manger: FragmentTransaction
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivitySubjectDetailsBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        /**set find id view*/
////        binding.subjectDetails.setOnClickListener(){
////
////        }
//
//        btnSubject = findViewById(R.id.subjectDetails2)
////        binding.assignments
//        btnAssignment = findViewById(R.id.assignments2)
////        binding.notes
//        btnNotes = findViewById(R.id.notes2)
////        binding.announcements
//        btnAnnouncement = findViewById(R.id.announcements2)
////        binding.syllabus
//        btnSyllabus = findViewById(R.id.syllabus2)
//
//        /**set the First Fragment*/
//        manger = fragmentManger.beginTransaction()
//            .replace(R.id.myMainFrag2,subjectFrag)
//        manger.commit()
//        btnSubject.setImageResource(R.drawable.ic_pink_subject)
//
//        //>>according to S'Pau's code:
//        ////>>according to S'Pau's code for first fragment:
//        ////        supportFragmentManager.beginTransaction().apply {
//        ////            replace(binding.myView.id,subjectFrag)
//        ////            commit()
//
//
////        //data from home activity
//        var subjectName: String? = intent.getStringExtra("subjectName") //>>need to add "?" to accept null inputs/values
//        var subjectDescription : String? = intent.getStringExtra("subjectDescription")
//        var imageSubject: Int = intent.getIntExtra("imageSubject",0)
//////        var quantity: Int = intent.getIntExtra("quantity",0)
//
//        //passing data to fragment 1 (subject frag)
//        var bundleSubjectName = Bundle()
//        bundleSubjectName.putString("subjectName", subjectName)
//        subjectFrag.arguments = bundleSubjectName
//
////        var bundleSubjectDescription = Bundle()
////        bundleSubjectDescription.putString("subjectDescription", subjectDescription)
////        subjectFrag.arguments = bundleSubjectDescription
////
//    }
//
//    fun addFragOnClick(view: View) {
//
//        /**set replace fragment*/
//        manger = fragmentManger.beginTransaction()
//        when(view){
//            btnSubject -> {
////                Toast.makeText(applicationContext, "Subject details", Toast.LENGTH_SHORT).show()
//                manger.replace(R.id.myMainFrag2,subjectFrag)
//                    .commit()
//                btnSubject.setImageResource(R.drawable.ic_pink_subject)
//                btnAssignment.setImageResource(R.drawable.ic_baseline_assignment_24)
//                btnNotes.setImageResource(R.drawable.ic_blue_notes_24)
//                btnAnnouncement.setImageResource(R.drawable.ic_announce_blu_24)
//                btnSyllabus.setImageResource(R.drawable.ic_baseline_list_alt_24)
//            }
//            btnSyllabus -> {
////                Toast.makeText(applicationContext, "Syllabus", Toast.LENGTH_SHORT).show()
//                manger.replace(R.id.myMainFrag2,syllabusFrag)
//                    .commit()
//                btnSubject.setImageResource(R.drawable.ic_subject_book_24)
//                btnAssignment.setImageResource(R.drawable.ic_baseline_assignment_24)
//                btnNotes.setImageResource(R.drawable.ic_blue_notes_24)
//                btnAnnouncement.setImageResource(R.drawable.ic_announce_blu_24)
//                btnSyllabus.setImageResource(R.drawable.ic_pink_syllabus_24)
//            }
//            btnAssignment -> {
////                Toast.makeText(applicationContext, "Assignments", Toast.LENGTH_SHORT).show()
//                manger.replace(R.id.myMainFrag2,assignmentFrag)
//                    .commit()
//                btnSubject.setImageResource(R.drawable.ic_subject_book_24)
//                btnAssignment.setImageResource(R.drawable.ic_pink_assignment_24)
//                btnNotes.setImageResource(R.drawable.ic_blue_notes_24)
//                btnAnnouncement.setImageResource(R.drawable.ic_announce_blu_24)
//                btnSyllabus.setImageResource(R.drawable.ic_baseline_list_alt_24)
//            }
//            btnNotes -> {
////                Toast.makeText(applicationContext, "Notes", Toast.LENGTH_SHORT).show()
//                manger.replace(R.id.myMainFrag2,notesFrag)
//                    .commit()
//                btnSubject.setImageResource(R.drawable.ic_subject_book_24)
//                btnAssignment.setImageResource(R.drawable.ic_baseline_assignment_24)
//                btnNotes.setImageResource(R.drawable.ic_pink_notes_24)
//                btnAnnouncement.setImageResource(R.drawable.ic_announce_blu_24)
//                btnSyllabus.setImageResource(R.drawable.ic_baseline_list_alt_24)
//            }
//            btnAnnouncement -> {
////                Toast.makeText(applicationContext, "Announcements", Toast.LENGTH_SHORT).show()
//                manger.replace(R.id.myMainFrag2,announcementFrag)
//                    .commit()
//                btnSubject.setImageResource(R.drawable.ic_subject_book_24)
//                btnAssignment.setImageResource(R.drawable.ic_baseline_assignment_24)
//                btnNotes.setImageResource(R.drawable.ic_blue_notes_24)
//                btnAnnouncement.setImageResource(R.drawable.ic_pink_announcement_24)
//                btnSyllabus.setImageResource(R.drawable.ic_baseline_list_alt_24)
//            }
//        }
//    }
//
//
//}