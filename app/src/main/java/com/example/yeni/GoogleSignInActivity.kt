package com.example.yeni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yeni.MainActivity.Companion.EXTRA_NAME
import com.example.yeni.databinding.ActivityGoogleSignInBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class GoogleSignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGoogleSignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleSignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textDisplayName.text = intent.getStringExtra(EXTRA_NAME)
        binding.logout.setOnClickListener {
            Firebase.auth.signOut()

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}