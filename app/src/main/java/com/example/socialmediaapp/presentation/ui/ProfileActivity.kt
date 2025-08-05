package com.example.socialmediaapp.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.socialmediaapp.databinding.ActivityProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        loadUserProfile()
    }

    private fun setupUI() {
        binding.toolbar.setNavigationOnClickListener { finish() }
        
        binding.btnMoreOptions.setOnClickListener {
            Toast.makeText(this, "Daha fazla seçenek yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.btnEditProfile.setOnClickListener {
            Toast.makeText(this, "Profil düzenleme özelliği yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.btnShareProfile.setOnClickListener {
            Toast.makeText(this, "Profil paylaşma özelliği yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.llFollowers.setOnClickListener {
            Toast.makeText(this, "Takipçi listesi yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        binding.llFollowing.setOnClickListener {
            Toast.makeText(this, "Takip edilen listesi yakında eklenecek", Toast.LENGTH_SHORT).show()
        }

        // TODO: Setup TabLayout and ViewPager for posts/videos/saved tabs
        // TODO: Setup RecyclerView for user posts
    }

    private fun loadUserProfile() {
        // TODO: Load user profile data from repository
        // For now, use sample data
        binding.tvUsername.text = "@kullanici_adi"
        binding.tvFullName.text = "Kullanıcı Adı Soyadı"
        binding.tvBio.text = "Hayatı seven, pozitif enerjili bir insanım. Fotoğraf çekmeyi ve seyahat etmeyi seviyorum."
        binding.tvPostsCount.text = "142"
        binding.tvFollowersCount.text = "2.5K"
        binding.tvFollowingCount.text = "847"
    }
}

