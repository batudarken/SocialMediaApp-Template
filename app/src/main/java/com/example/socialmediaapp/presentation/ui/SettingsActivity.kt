package com.example.socialmediaapp.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.socialmediaapp.databinding.ActivitySettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        binding.toolbar.setNavigationOnClickListener { finish() }

        binding.llAccountInfo.setOnClickListener {
            Toast.makeText(this, "Hesap Bilgileri yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.llPrivacy.setOnClickListener {
            Toast.makeText(this, "Gizlilik Ayarları yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.llSecurity.setOnClickListener {
            Toast.makeText(this, "Güvenlik Ayarları yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.switchPushNotifications.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Anlık Bildirimler: $isChecked", Toast.LENGTH_SHORT).show()
        }

        binding.switchLikesNotifications.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Beğeni ve Yorum Bildirimleri: $isChecked", Toast.LENGTH_SHORT).show()
        }

        binding.switchMessagesNotifications.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Mesaj Bildirimleri: $isChecked", Toast.LENGTH_SHORT).show()
        }

        binding.llThemeSelection.setOnClickListener {
            Toast.makeText(this, "Tema seçimi yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.llLanguage.setOnClickListener {
            Toast.makeText(this, "Dil seçimi yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.llHelpSupport.setOnClickListener {
            Toast.makeText(this, "Yardım ve Destek yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.llAbout.setOnClickListener {
            Toast.makeText(this, "Hakkında yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogout.setOnClickListener {
            // TODO: Implement actual logout logic
            Toast.makeText(this, "Çıkış yapılıyor...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}

