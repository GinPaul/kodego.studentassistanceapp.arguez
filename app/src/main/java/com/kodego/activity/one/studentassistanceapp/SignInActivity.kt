package com.kodego.activity.one.studentassistanceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.kodego.activity.one.studentassistanceapp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignInBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)

        //add this to initialize auth = FirebaseAuth
        mAuth = FirebaseAuth.getInstance()

        setContentView(binding.root)

        //toggle to signUp activity
        binding.textViewSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        //proceed to sign in
        binding.nextBtn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty())

                loginUser(email, pass)
            else
                Toast.makeText(
                    applicationContext,
                    "Empty fields are not allowed",
                    Toast.LENGTH_SHORT
                ).show()
        }
    }

    private fun loginUser(email: String, pass: String) {
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
            if (it.isSuccessful) {

                val intent = Intent(this, StudentAppHomeScreen::class.java)
                startActivity(intent)

                //put this to prevent view from going back to Sign In
                finish()
            }
            else
                Toast.makeText(applicationContext, it.exception.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun init(view: View) {
        mAuth = FirebaseAuth.getInstance()
    }
}
