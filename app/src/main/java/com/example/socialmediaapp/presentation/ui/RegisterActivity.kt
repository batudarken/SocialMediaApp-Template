package com.example.socialmediaapp.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.socialmediaapp.R
import com.example.socialmediaapp.databinding.ActivityRegisterBinding
import com.example.socialmediaapp.presentation.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        observeViewModel()
    }

    private fun setupUI() {
        binding.btnRegister.setOnClickListener {
            val firstName = binding.etFirstName.text.toString().trim()
            val lastName = binding.etLastName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmPassword = binding.etConfirmPassword.text.toString().trim()
            
            authViewModel.register(firstName, lastName, email, password, confirmPassword)
        }

        binding.tvLogin.setOnClickListener {
            finish() // Go back to login screen
        }

        // Social login buttons (dummy implementations)
        binding.btnGoogleLogin.setOnClickListener {
            Toast.makeText(this, "Google ile giriş yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.btnAppleLogin.setOnClickListener {
            Toast.makeText(this, "Apple ile giriş yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.btnTwitterLogin.setOnClickListener {
            Toast.makeText(this, "Twitter ile giriş yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.btnTiktokLogin.setOnClickListener {
            Toast.makeText(this, "TikTok ile giriş yakında eklenecek", Toast.LENGTH_SHORT).show()
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            authViewModel.registerState.collect { result ->
                when (result) {
                    is AuthViewModel.AuthResult.Idle -> {
                        hideLoading()
                    }
                    is AuthViewModel.AuthResult.Loading -> {
                        showLoading()
                    }
                    is AuthViewModel.AuthResult.Success -> {
                        hideLoading()
                        // Navigate to email verification screen
                        val intent = Intent(this@RegisterActivity, EmailVerificationActivity::class.java)
                        intent.putExtra("email", binding.etEmail.text.toString().trim())
                        startActivity(intent)
                        finish()
                    }
                    is AuthViewModel.AuthResult.Error -> {
                        hideLoading()
                        Toast.makeText(this@RegisterActivity, result.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.btnRegister.isEnabled = false
    }

    private fun hideLoading() {
        binding.progressBar.visibility = View.GONE
        binding.btnRegister.isEnabled = true
    }
}

