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
import com.bumptech.glide.Glide
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityStudentAppHomeScreenBinding
import com.kodego.activity.one.studentassistanceapp.notification.TaskNotification
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
    private val imageKodego = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAwFBMVEX///8nQmbkGlAjP2QAKVb7/Pw+U3IALlnkHlPQ1NoMM1zkFU4VN18dO2LmMl2cpLLe4eW+w8xyf5QAJlUALFjiAD/x8vTiADcAIlMRNV5OYHwzS2zjAEbo6u3X2t+PmKhdbYW0usTuh5t9iJvGytJvfJFjcomXoK6nrrr64ubpWHc3TW7nRWr+9vdGWneFkKHsd47vkKL87O/yprTqZ4L0ucT5193mQGbseZDzsLz75urxn673ytPxorHrbIXvlaZz2ewIAAAGeElEQVR4nO2b61ajPBSGOZSitFiV0oNWrVPP2nY+Z9Q5z/3f1ahAdgIJxU9sSNf7/DNGVh4DO3snYFkAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADCPo0G1NlO56raixa7Y1vNb0cGRnvHUTi+ybduNjvm2Wf+5LfQ3Yxq9kf1Ki1PcD16bwpm+YdXIWWJj2zSLqaDt2joHVhvM0I62k5ZMcFMMs7uUKTLBTblLrV5fUDxngm5/MyKNZS19TpFm0PV3V/+tIZyQYhAywWBzBJ8V6UbdxBl8oaDoBpuS0GRwN+pmClrWZSgobp6gNXUFw01ZJ4iTQBAMF7oHVDdnUS7SjJe6h1QvAxZn2L3a2tM9qFpZZGLhQZcpblKwmY2zGby1Zl02m7qHVR97LX7e2mw+L3QPrC6OSPDl2aNn0u/pHlpNsOgyTspBiqtZSWw40yyZcdtpyyVbGzdiK0qmQ9K3OodWD9Jb0nOzG7d7rnFstXDEqqbgkmveZd7GR5tDtjRMhfZTFl+jMz0jq4kL9sDZnvibZZYE2H2Tc5tLtvQVU7QDJn+oY2j1QFFGkmZ7oeIGNgjKZQJZqUTRRvprA6AlITyQduDS1dM1j60e6EFzPXmPJZ1oHMt7NBpWMZUUgiy3sQPz0rcrttRHJcU8S8rNC6jbFEZOSrpRymNaQKWRd8vLXO4/YdRJG4XRlcUD3c39q7WMrR4WLIyujiAUkQzKUC/YflqVVYCtKnbLlNMo2t6utJJ7FFBDM9YMKoxKwyhxxPLz0IiSn6LjijBKHLM/MWHN2GUzGLZX906haR/vf+DYamHQpYdKkY3KoPNT/3J1b60c0snLm0r3czrOaHadQZF/9MbNXvrLRm8Tv2MmPG72m7ssUr3nC+vEvaL//Zz7YRCwJ7ixpRS93SXs836Jh/F3SffrneHwK/cz7WoUNuYawimtavyuxcPQcZzhQ6H7PO44zuSGa6GNqzcsNGuEG5+Qmdw9izidu0L/nZd2Z8jfwVct6f+oIVBekssunVfDnXz/P5MXQSd+5BtpWaycD62NXXqryxcXwi2p4ZfYSQzF5n1WSjWtIB6MWazPF0xSw8dhIlh4PqdsvWlWcjNwSTBfxsoM55PXh9CZfCpcakHVYoNqfu+QhlVY6WWGT4mgJP7wK3/UnPytzQT7xdNAieG3JMp0OrJlbxCq7wddUEopO4AoGn5Po8zwWnq5I58Um5GiUnCQFncFwyzKxMUsIIGSm2akqLTtJF/D8obzThplvikvSdsEbl+/4jlbwRR5SN7wTh1lGHukqP1d4hl9HaLIJXOGn9IoM5nLuydQjut29RYaJOgeKuoB0fAhW+of5b0zqE5xXZ2KS+61UVXBIxheZ1FGVk4JnFS49MfDjUK9lysYZlHm8+qLL1ffHh8OfUPhdtXxgDe8SaPMU5XLcx+A3epR5AT9koDHGVaLMowLCtNaKmIqV8sXLTLMoky8IsowKJfQUREPqiYezPBHmqzJKgoF9FK4v/5C44Q2DstP0JjhVic1dGJ1OpODe5/j3SN+K+xIzF9xRJgZ3kwcRlx9FjPFtadvXnaThr3jbZ6Cb2J49zN2nCqKu9si2Z0SrPvzjAFti/k5cnVrcnNupTOYFvcqxSu7L16MrRjjtZfD4sd2PCPxv02P34vYz6cyxVnfVV01WHs1PFWOJRcUeMPJV8vbUSse5z+O4ojWnp3uqSdRPFfjDF9XRVL8L3/NXld5TR1fnyxC1WjED3w5w/h1g3uuVCwxHGkoE+m0t6rh8FfSMt9SKKoNR1q23QZtXz6NCsP4b9akUlQYut2+ri/59qb9qMURlhnyx0yk+JvvmhkG/EVbUftS52Gbx2Gdh2rDzhbfyBSHfGtqON7zhMs2iP0Sw/iH0DVTFOqM1HDt6Ut1pIbpOeGvXN+5k7TzpaKhhr9j6dr3rDhxOmKVYaih9XkYD2Xl0vxP3PkrtJhqaN3/Ur2MkcNYw8rAUD8wXAUM9QPDVZhj+H+r1StTDN3bdoH9/LyeToudDm1DDG23SDgS98pmrbDYyTbGUErA99wu2VUz1tDn341Zlv4vYKiPU/Ueqm1H/HZEyW6rbY+a+pr3M23ldqAbiW+8LcbKnq1GvXaZw5u15ER2fsNz2Vf0dBv00qUUT867egIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACDyD3wgaEIFwMb9AAAAAElFTkSuQmCCe"

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
            Toast.makeText(applicationContext, "Showing Assignments..", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SubjectDetails::class.java)
            startActivity(intent)
        }

        //to open notification layout
        binding.alarmNotification.setOnClickListener() {
            Toast.makeText(applicationContext, "Create your reminder.", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, TaskNotification::class.java)
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
        Glide.with(this)
            .load(imageKodego)
            .override(100,200) //to override the size of the image
            .circleCrop() //to circle crop the image
            .into(binding.profileImage)

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

        }

}