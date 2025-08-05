package com.example.socialmediaapp.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.socialmediaapp.databinding.ActivityLiveStreamBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LiveStreamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiveStreamBinding
    private var isLive: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveStreamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        binding.btnGoLiveLarge.setOnClickListener { startLiveStream() }
        binding.btnStartStream.setOnClickListener { startLiveStream() }
        binding.btnEndStream.setOnClickListener { endLiveStream() }
        binding.btnClose.setOnClickListener { finish() }
        binding.btnSwitchCamera.setOnClickListener { Toast.makeText(this, "Kamera değiştirme özelliği yakında eklenecek", Toast.LENGTH_SHORT).show() }
        binding.btnSettings.setOnClickListener { Toast.makeText(this, "Yayın ayarları özelliği yakında eklenecek", Toast.LENGTH_SHORT).show() }
        binding.btnSendComment.setOnClickListener { sendComment() }
        binding.btnEffects.setOnClickListener { Toast.makeText(this, "Efektler özelliği yakında eklenecek", Toast.LENGTH_SHORT).show() }

        // Initially show preview overlay
        binding.llPreviewOverlay.visibility = View.VISIBLE
        binding.llBottomControls.visibility = View.GONE
        binding.llLiveStatus.visibility = View.GONE
    }

    private fun startLiveStream() {
        val streamTitle = binding.etStreamTitle.text.toString().trim()
        if (streamTitle.isBlank()) {
            Toast.makeText(this, "Yayın başlığı boş olamaz", Toast.LENGTH_SHORT).show()
            return
        }

        // Simulate starting live stream
        binding.llPreviewOverlay.visibility = View.GONE
        binding.llLoading.visibility = View.VISIBLE

        // In a real app, this would involve connecting to a streaming service
        // For now, simulate a delay and then go live
        binding.root.postDelayed({ // Simulate network delay
            binding.llLoading.visibility = View.GONE
            isLive = true
            binding.llBottomControls.visibility = View.VISIBLE
            binding.llLiveStatus.visibility = View.VISIBLE
            binding.btnStartStream.visibility = View.GONE
            binding.btnEndStream.visibility = View.VISIBLE
            Toast.makeText(this, "Canlı yayın başladı!", Toast.LENGTH_SHORT).show()
            // TODO: Initialize video stream API here
        }, 2000)
    }

    private fun endLiveStream() {
        isLive = false
        Toast.makeText(this, "Canlı yayın sona erdi.", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun sendComment() {
        val comment = binding.etComment.text.toString().trim()
        if (comment.isNotBlank()) {
            // TODO: Send comment to live stream chat
            Toast.makeText(this, "Yorum gönderildi: $comment", Toast.LENGTH_SHORT).show()
            binding.etComment.text?.clear()
        }
    }
}

