package com.kodego.activity.one.studentassistanceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodego.activity.one.studentassistanceapp.databinding.ActivitySubjectDetailsBinding

class SubjectDetails : AppCompatActivity() {

    lateinit var binding: ActivitySubjectDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubjectDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //data from home activity
        var itemName: String? = intent.getStringExtra("itemName") //>>need to add "?" to accept null inputs/values
        var itemDescription : String? = intent.getStringExtra("itemDescription")
        var imageItem: Int = intent.getIntExtra("itemImage",0)
        var quantity: Int = intent.getIntExtra("quantity",0)

//        binding.imgSubjectDetails.setImageResource()

//        binding.tvMainSubjectDetails.text = itemName
//        binding.txtDescription2.text = itemDescription
//        binding.tvQuantityProdDetail.text = quantity.toString()
    }



}