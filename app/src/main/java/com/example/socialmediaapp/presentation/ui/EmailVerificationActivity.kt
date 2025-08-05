package com.example.socialmediaapp.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.socialmediaapp.R
import com.example.socialmediaapp.databinding.ActivityEmailVerificationBinding
import com.example.socialmediaapp.presentation.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EmailVerificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmailVerificationBinding
    private val authViewModel: AuthViewModel by viewModels()
    private var email: String? = null
    private var countDownTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        email = intent.getStringExtra("email")
        if (email.isNullOrBlank()) {
            Toast.makeText(this, "E-posta adresi bulunamadı.", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        binding.tvVerificationMessage.text = getString(R.string.verification_message)

        setupUI()
        observeViewModel()
        startResendTimer()
    }

    private fun setupUI() {
        binding.btnVerify.setOnClickListener {
            val code = binding.etVerificationCode.text.toString().trim()
            if (email != null) {
                authViewModel.verifyEmail(email!!, code)
            }
        }

        binding.tvResendCode.setOnClickListener {
            if (email != null) {
                // TODO: Implement resend verification code functionality
                Toast.makeText(this, "Kod tekrar gönderiliyor...", Toast.LENGTH_SHORT).show()
                startResendTimer()
            }
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            authViewModel.verifyEmailState.collect { result ->
                when (result) {
                    is AuthViewModel.AuthResult.Idle -> {
                        hideLoading()
                    }
                    is AuthViewModel.AuthResult.Loading -> {
                        showLoading()
                    }
                    is AuthViewModel.AuthResult.Success -> {
                        hideLoading()
                        Toast.makeText(this@EmailVerificationActivity, R.string.verification_successful, Toast.LENGTH_SHORT).show()
                        // Navigate to home screen
                        startActivity(Intent(this@EmailVerificationActivity, HomeActivity::class.java))
                        finish()
                    }
                    is AuthViewModel.AuthResult.Error -> {
                        hideLoading()
                        Toast.makeText(this@EmailVerificationActivity, result.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun startResendTimer() {
        binding.tvResendCode.isEnabled = false
        countDownTimer?.cancel()
        countDownTimer = object : CountDownTimer(60000, 1000) { // 60 seconds
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                binding.tvResendCode.text = getString(R.string.resend_in_seconds, seconds.toInt())
            }

            override fun onFinish() {
                binding.tvResendCode.text = getString(R.string.resend)
                binding.tvResendCode.isEnabled = true
            }
        }.start()
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.btnVerify.isEnabled = false
    }

    private fun hideLoading() {
        binding.progressBar.visibility = View.GONE
        binding.btnVerify.isEnabled = true
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer?.cancel()
    }
}

