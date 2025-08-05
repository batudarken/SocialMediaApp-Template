package com.example.socialmediaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialmediaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupUI()
        setupClickListeners()
        
        Toast.makeText(this, "🎉 SocialApp Demo Ready!", Toast.LENGTH_LONG).show()
    }
    
    private fun setupUI() {
        // Demo content setup
    }
    
    private fun setupClickListeners() {
        binding.fabCreatePost?.setOnClickListener {
            Toast.makeText(this, "📝 Yeni paylaşım özelliği yakında!", Toast.LENGTH_SHORT).show()
        }
    }
}
