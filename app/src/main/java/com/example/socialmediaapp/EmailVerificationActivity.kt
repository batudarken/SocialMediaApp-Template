package com.example.socialmediaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.socialmediaapp.databinding.ActivityEmailVerificationBinding

class EmailVerificationActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityEmailVerificationBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupClickListeners()
        
        Toast.makeText(this, "📧 Demo kod: 123456", Toast.LENGTH_LONG).show()
    }
    
    private fun setupClickListeners() {
        binding.btnVerify.setOnClickListener {
            val code = getEnteredCode()
            if (code == "123456") {
                Toast.makeText(this, "✅ Email doğrulandı! Ana sayfaya yönlendiriliyorsunuz.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "❌ Hatalı kod! Demo kod: 123456", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun getEnteredCode(): String {
        return binding.etCode1.text.toString() +
               binding.etCode2.text.toString() +
               binding.etCode3.text.toString() +
               binding.etCode4.text.toString() +
               binding.etCode5.text.toString() +
               binding.etCode6.text.toString()
    }
}
