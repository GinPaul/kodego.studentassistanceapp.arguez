package com.kodego.activity.one.studentassistanceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.kodego.activity.one.studentassistanceapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //add this to initialize auth = FirebaseAuth
        mAuth = FirebaseAuth.getInstance()

        //toggle to signIn activity
        binding.textViewSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        binding.nextBtn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passEt.text.toString()
            val verifyPass = binding.verifyPassEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && verifyPass.isNotEmpty()) {
                if (pass == verifyPass) {

                    registerUser(email, pass)

                } else {
                    Toast.makeText(applicationContext, "Password is not same", Toast.LENGTH_SHORT).show()
                }
            } else
                Toast.makeText(applicationContext, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
        }
    }
    private fun registerUser(email: String, pass: String) {
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
            if (it.isSuccessful) {

                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
            }

            else
                Toast.makeText(applicationContext, it.exception.toString(), Toast.LENGTH_SHORT).show()

        }
    }

    private fun init(view: View) {
//        navController = Navigation.findNavController(view)
        mAuth = FirebaseAuth.getInstance()
    }
}