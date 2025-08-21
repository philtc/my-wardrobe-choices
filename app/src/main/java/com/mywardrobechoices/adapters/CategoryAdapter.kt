package com.mywardrobechoices.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mywardrobechoices.databinding.ItemCategoryBinding
import com.mywardrobechoices.models.ItemCategory

class CategoryAdapter(
    private val categories: List<ItemCategory>,
    private val onCategoryClick: (ItemCategory) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    
    private var selectedPosition = 0
    
    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(category: ItemCategory, isSelected: Boolean) {
            binding.tvCategoryName.text = category.name.lowercase().replaceFirstChar { it.uppercase() }
            binding.root.isSelected = isSelected
            
            binding.root.setOnClickListener {
                val oldPosition = selectedPosition
                selectedPosition = adapterPosition
                notifyItemChanged(oldPosition)
                notifyItemChanged(selectedPosition)
                onCategoryClick(category)
            }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CategoryViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position], position == selectedPosition)
    }
    
    override fun getItemCount() = categories.size
}