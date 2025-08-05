package com.example.socialmediaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.socialmediaapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityLoginBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupClickListeners()
        
        Toast.makeText(this, "📧 Demo: demo@example.com\n🔐 Şifre: 123456", Toast.LENGTH_LONG).show()
    }
    
    private fun setupClickListeners() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            
            if (email == "demo@example.com" && password == "123456") {
                Toast.makeText(this, "✅ Giriş Başarılı!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "❌ Hatalı giriş!\n📧 demo@example.com\n🔐 123456", Toast.LENGTH_LONG).show()
            }
        }
        
        binding.tvSignUp?.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
