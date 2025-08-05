package com.example.socialmediaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.socialmediaapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityRegisterBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupClickListeners()
    }
    
    private fun setupClickListeners() {
        binding.btnRegister.setOnClickListener {
            Toast.makeText(this, "✅ Demo kayıt başarılı! Email doğrulama sayfasına yönlendiriliyorsunuz.", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, EmailVerificationActivity::class.java))
            finish()
        }
        
        binding.ivBack?.setOnClickListener {
            finish()
        }
    }
}
