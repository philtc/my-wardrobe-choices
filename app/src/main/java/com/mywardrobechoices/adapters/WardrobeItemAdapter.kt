package com.mywardrobechoices.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mywardrobechoices.databinding.ItemWardrobeBinding
import com.mywardrobechoices.models.WardrobeItem

class WardrobeItemAdapter(
    private val onItemClick: (WardrobeItem) -> Unit
) : RecyclerView.Adapter<WardrobeItemAdapter.WardrobeItemViewHolder>() {
    
    private var items = listOf<WardrobeItem>()
    
    fun updateItems(newItems: List<WardrobeItem>) {
        items = newItems
        notifyDataSetChanged()
    }
    
    inner class WardrobeItemViewHolder(private val binding: ItemWardrobeBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(item: WardrobeItem) {
            binding.tvItemName.text = item.name
            binding.ivItemImage.setImageResource(item.imageResId)
            binding.root.alpha = if (item.isUnlocked) 1.0f else 0.5f
            
            binding.root.setOnClickListener {
                if (item.isUnlocked) {
                    onItemClick(item)
                }
            }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WardrobeItemViewHolder {
        val binding = ItemWardrobeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return WardrobeItemViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: WardrobeItemViewHolder, position: Int) {
        holder.bind(items[position])
    }
    
    override fun getItemCount() = items.size
}