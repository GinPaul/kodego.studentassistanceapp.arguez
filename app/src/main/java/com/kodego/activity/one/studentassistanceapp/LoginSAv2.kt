package com.kodego.activity.one.studentassistanceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kodego.activity.one.studentassistanceapp.admin.AdminPage
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityLoginSav2Binding

class LoginSAv2 : AppCompatActivity() {
    lateinit var binding: ActivityLoginSav2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSav2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //login
        binding.btnLoginv2.setOnClickListener(){
            var userName: String = binding.etUserNamev2.text.toString()
            var password: String = binding.etPasswordv2.text.toString()
            checkCredential(userName, password)
        }
    }

    private fun checkCredential(userName: String, password: String): Boolean {
        val correctUserName: String = "admin"
        val correctPassword: String = "admin123"

        val correctUserName2: String = "Paul"
        val correctPassword2: String = "pass123"

        if((correctUserName == userName) && (correctPassword == password)){
            val intent = Intent(this, AdminPage::class.java)
            intent.putExtra("nameID", userName)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "Logging in...", Toast.LENGTH_SHORT).show()
            return true
        }else if((correctUserName2 == userName) && (correctPassword2 == password)) {
            val intent = Intent(this, StudentAppHomeScreen::class.java)
            intent.putExtra("nameID", userName)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "Logging in...", Toast.LENGTH_SHORT).show()
            return true
        }else{
            Toast.makeText(applicationContext, "Invalid Credentials. Try again.", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}

