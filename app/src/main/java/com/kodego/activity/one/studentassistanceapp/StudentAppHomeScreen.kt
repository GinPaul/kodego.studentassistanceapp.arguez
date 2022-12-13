package com.kodego.activity.one.studentassistanceapp

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityStudentAppHomeScreenBinding
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

    //image from internet
    private val imageKodego = "https://toppng.com/uploads/preview/imagenes-de-spiderman-spiderman-115632497617lyo2fcsg4.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //step 2: declare binding variable with inflater
        binding = ActivityStudentAppHomeScreenBinding.inflate(layoutInflater)

        //step 3: change "R.layout.activity_student_app_home_screen" to "binding.root"
        setContentView(binding.root)

        //step 4: create functionality for the calendar/first button:
        /**Calendar*/
        binding.imgCalendarButton1.setOnClickListener() {
            Toast.makeText(applicationContext, "Opening calendar...", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, StudentCalendar::class.java)
            startActivity(intent)
        }

        //showing current date and time
        textView = findViewById(R.id.tvDateToday)
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("EEE | MMM dd, yyyy")
        date = simpleDateFormat.format(calendar.time)
        textView.text = date


        //data source using data Class
        var subjectList: MutableList<Subjects> = mutableListOf<Subjects>(
            Subjects(R.drawable.inorganichemistry2, 1, "Chemistry 17", "Fundamentals of Inorganic Chemistry"),
            Subjects(R.drawable.mathpic, 2, "Math 11", "Advanced Mathematics"),
            Subjects(R.drawable.physicsball, 3, "Physics 21", "Applied Physics"),
            Subjects(R.drawable.libliterature, 4, "Philosophy 100", "Introduction to Philosophy"),
            Subjects(R.drawable.biologyplantladybug, 5, "Biology 2", "General Biology"),
        )

        //pass data source to adapter (need lateinit var adapter)
        adapter = SubjectAdapter(subjectList)
        adapter.onItemClick = {
            Toast.makeText(applicationContext, it.subjectName, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SubjectDetailsV2::class.java)
            intent.putExtra("subjectName", it.subjectName)
            intent.putExtra("subjectDescription", it.subjectDescription)
            intent.putExtra("imageSubject", it.imageSubject)
            intent.putExtra("subjectNumber", it.subjectNumber)
            startActivity(intent) //>>don't place "finish" so that the can go back the product list

        }
        binding.cvSubjectsRecylcer.adapter = adapter
        binding.cvSubjectsRecylcer.layoutManager = LinearLayoutManager(this)

        //transferring view to Assignments & other fragments thru SubjectDetails
        binding.btnToAssignFrag.setOnClickListener() {
            Toast.makeText(applicationContext, "Showing Others...", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SubjectDetails::class.java)
            startActivity(intent)
        }

        /**for dialog*/
//        binding.btnCustomDialog.setOnClickListener(){
//            showCustomDialog()
//        }

//        binding.btnBuiltIn.setOnClickListener(){
//            showBuiltInDialog()
//        }

        /**for camera*/
        binding.imgProfileEdit.setOnClickListener(){
//            showCamera()
            AlertDialog.Builder( this).setMessage("Which data source?")
                .setPositiveButton("Camera"){dialog, item ->
                    showCamera()
                    binding.imgProfileEdit.setImageResource(R.drawable.ic_baseline_edit_24)
                }.setNegativeButton("Gallery"){dialog, item ->
                    showGallery()
                    binding.imgProfileEdit.setImageResource(R.drawable.ic_baseline_edit_24)
                }.show()
        }

        /**getting image from the internet into the profile image*/
//        Glide.with(this)
//            .load(imageKodego)
////            .override(100,200) //to override the size of the image
////            .circleCrop() //to circle crop the image
//            .into(binding.profileImage)

        /**getting image from the gallery*/
//        binding.btnGallery.setOnClickListener(){
//            showGallery() //<< create a function showGallery
//        }


    }
    private fun showCamera() {
        Dexter.withContext(this).withPermission(
            Manifest.permission.CAMERA
        ).withListener(object: PermissionListener{
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission approved!", Toast.LENGTH_SHORT).show()
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//                startActivity(cameraIntent) << this is just to open the camera but no next step
                cameraLauncher.launch(cameraIntent)
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission denied!", Toast.LENGTH_SHORT).show()
                gotoSettings()
            }

            override fun onPermissionRationaleShouldBeShown(
                request: PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }
        }).onSameThread().check() //<<don't forget this!
    }

    //help the user go to Settings
    private fun gotoSettings() {
        AlertDialog.Builder( this).setMessage("Camera Permission is denied. Please go to Settings to enable camera permission.")
            .setPositiveButton("Go to Settings"){dialog, item ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                var uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
            }.setNegativeButton("Cancel"){dialog, item ->
                dialog.dismiss()
            }.show()
    }

    private fun showGallery(){
        Dexter.withContext(this).withPermission(
            Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(object: PermissionListener{
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission granted!", Toast.LENGTH_SHORT).show()
                val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                galleryLauncher.launch(galleryIntent)
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission denied!", Toast.LENGTH_SHORT).show()
                gotoSettings()
            }

            override fun onPermissionRationaleShouldBeShown(
                request: PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }

        }).onSameThread().check() //<<don't forget this!
    }

    //handles images from camera
    val cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK){
            result.data?.extras.let{
                val image: Bitmap = result.data?.extras?.get("data") as Bitmap
                binding.profileImage.setImageBitmap(image)
            }
        }
    }

    //handles images from the gallery
    val galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let{
                val selectedImage = result.data?.data
                binding.profileImage.setImageURI(selectedImage)
            }
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