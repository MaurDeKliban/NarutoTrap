package com.example.narutotrap.narutoViewModel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.narutotrap.databinding.NarutoItemBinding
import com.example.narutotrap.network.NarutoCharacters

class NarutoGridAdapter :
    ListAdapter<NarutoCharacters, NarutoGridAdapter.NarutoViewHolder>(DiffCallback) {
    class NarutoViewHolder(
        private val binding: NarutoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(narutoCharacters: NarutoCharacters) {
            val imageUrl = narutoCharacters.images
            binding.narutoImage.load(imageUrl)

        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<NarutoCharacters>() {
        override fun areItemsTheSame(
            oldItem: NarutoCharacters, newItem: NarutoCharacters
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NarutoCharacters, newItem: NarutoCharacters): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NarutoViewHolder {
        return NarutoViewHolder(
            NarutoItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: NarutoViewHolder, position: Int) {
        val narutoCharacters = getItem(position)
        holder.bind(narutoCharacters)
    }

}