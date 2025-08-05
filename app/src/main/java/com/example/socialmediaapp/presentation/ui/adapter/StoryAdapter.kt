package com.example.socialmediaapp.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.socialmediaapp.databinding.StoryItemBinding
import com.example.socialmediaapp.domain.model.Story

class StoryAdapter(
    private val onStoryClick: (Story) -> Unit
) : ListAdapter<Story, StoryAdapter.StoryViewHolder>(StoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding = StoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class StoryViewHolder(private val binding: StoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(story: Story) {
            // Bind story data to views
            binding.tvUsername.text = story.user?.username ?: "Unknown User"
            
            // Set story border based on viewed status
            if (story.isViewed) {
                // TODO: Set viewed story border
            } else {
                // TODO: Set unviewed story border
            }

            // Set click listener
            binding.root.setOnClickListener { onStoryClick(story) }

            // TODO: Load profile image and story thumbnail
        }
    }

    class StoryDiffCallback : DiffUtil.ItemCallback<Story>() {
        override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem == newItem
        }
    }
}

