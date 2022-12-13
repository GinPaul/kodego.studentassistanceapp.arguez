package com.kodego.activity.one.studentassistanceapp

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.kodego.activity.one.studentassistanceapp.databinding.ActivitySubjectDetailsV2Binding

class SubjectDetailsV2 : AppCompatActivity() {

    lateinit var binding: ActivitySubjectDetailsV2Binding

    /**call id of the bottom navigation*/
    private lateinit var btnSubject: ImageButton
    private lateinit var btnAssignment: ImageButton
    private lateinit var btnNotes: ImageButton
    private lateinit var btnAnnouncement: ImageButton
    private lateinit var btnSyllabus: ImageButton

    private lateinit var manger: FragmentTransaction
    private val fragmentManger = supportFragmentManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubjectDetailsV2Binding.inflate(layoutInflater)

        setContentView(binding.root)


        //to get data from home activity to subject details xml
        var subjectName: String? = intent.getStringExtra("subjectName") //>>need to add "?" to accept null inputs/values
        var subjectDescription : String? = intent.getStringExtra("subjectDescription")
        var imageSubject: Int = intent.getIntExtra("imageSubject",0)
        var quantity: Int = intent.getIntExtra("quantity",0)

//        //passing data to subject details for fragment only
//        var bundleSubjectDetails = Bundle()
//        bundleSubjectDetails.putString("subjectName", subjectName)

        //pass the data to Subject Details view upon click in the recycler view of home activity
        binding.imgOfSubjectInSubjectDetailsView.setImageResource(imageSubject)
        binding.tvSubjectNameInSubjectDetailsView.text = subjectName
        binding.tvDescriptionInSubjectDetailsView2.text = subjectDescription
//        binding.tvQuantityProdDetail.text = quantity.toString()


        /**create a button here to go to assignment fragment*/



    }

}