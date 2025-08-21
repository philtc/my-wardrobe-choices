package com.mywardrobechoices

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mywardrobechoices.adapters.CategoryAdapter
import com.mywardrobechoices.adapters.WardrobeItemAdapter
import com.mywardrobechoices.data.WardrobeRepository
import com.mywardrobechoices.databinding.ActivityMainBinding
import com.mywardrobechoices.models.*
import com.mywardrobechoices.utils.PreferencesManager

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var repository: WardrobeRepository
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var itemAdapter: WardrobeItemAdapter
    private lateinit var preferencesManager: PreferencesManager
    
    private var currentCharacter = Character()
    private var currentCategory = ItemCategory.FACE
    private var gameProgress = GameProgress()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        repository = WardrobeRepository()
        preferencesManager = PreferencesManager(this)
        gameProgress = preferencesManager.loadGameProgress()
        
        setupUI()
        setupRecyclerViews()
        updateCharacterDisplay()
        loadCategoryItems(ItemCategory.BODY)
    }
    
    private fun setupUI() {
        
        binding.btnSaveOutfit.setOnClickListener {
            saveCurrentOutfit()
        }
        
    }
    
    private fun setupRecyclerViews() {
        // Category selector
        val categories = listOf(
            ItemCategory.BODY, ItemCategory.FACE, ItemCategory.HAIR, ItemCategory.EYES,
            ItemCategory.TOP, ItemCategory.BOTTOM, ItemCategory.SHOES,
            ItemCategory.HAT, ItemCategory.ACCESSORY, ItemCategory.PET,
            ItemCategory.BACKGROUND
        )
        
        categoryAdapter = CategoryAdapter(categories) { category ->
            currentCategory = category
            loadCategoryItems(category)
        }
        
        binding.recyclerCategories.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }
        
        // Items selector
        itemAdapter = WardrobeItemAdapter { item ->
            applyItemToCharacter(item)
            updateCharacterDisplay()
        }
        
        binding.recyclerItems.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = itemAdapter
        }
    }
    
    private fun loadCategoryItems(category: ItemCategory) {
        val allItems = when (category) {
            ItemCategory.BODY -> repository.getBodyOptions()
            ItemCategory.FACE -> repository.getFaceOptions(currentCharacter.style)
            ItemCategory.HAIR -> repository.getHairOptions(currentCharacter.style)
            ItemCategory.EYES -> repository.getEyeOptions()
            ItemCategory.TOP -> repository.getTopOptions(currentCharacter.style)
            ItemCategory.BOTTOM -> repository.getBottomOptions(currentCharacter.style)
            ItemCategory.SHOES -> repository.getShoeOptions()
            ItemCategory.HAT -> repository.getHatOptions()
            ItemCategory.ACCESSORY -> repository.getAccessoryOptions()
            ItemCategory.PET -> repository.getPetOptions()
            ItemCategory.BACKGROUND -> repository.getBackgroundOptions()
        }
        
        // Update unlock status based on game progress
        val items = allItems.map { item ->
            item.copy(isUnlocked = gameProgress.unlockedItems.contains(item.id) || item.unlockLevel <= gameProgress.level)
        }
        
        itemAdapter.updateItems(items)
    }
    
    private fun applyItemToCharacter(item: WardrobeItem) {
        when (item.category) {
            ItemCategory.BODY -> currentCharacter.style = item.style
            ItemCategory.FACE -> currentCharacter.face = item.id
            ItemCategory.HAIR -> currentCharacter.hair = item.id
            ItemCategory.EYES -> currentCharacter.eyes = item.id
            ItemCategory.TOP -> currentCharacter.outfit.top = item.id
            ItemCategory.BOTTOM -> currentCharacter.outfit.bottom = item.id
            ItemCategory.SHOES -> currentCharacter.outfit.shoes = item.id
            ItemCategory.HAT -> currentCharacter.outfit.hat = item.id
            ItemCategory.ACCESSORY -> {
                val accessory = Accessory(item.id, AccessoryType.OTHER, item.name)
                if (!currentCharacter.accessories.any { it.id == item.id }) {
                    currentCharacter.accessories.add(accessory)
                }
            }
            ItemCategory.PET -> {
                currentCharacter.pet = Pet(item.id, PetType.DOG, item.name)
            }
            ItemCategory.BACKGROUND -> currentCharacter.background = item.id
        }
        
        // Gain experience for changing items
        gameProgress.addExperience(5)
        gameProgress.earnCoins(2)
        saveProgress()
    }
    
    private fun updateCharacterDisplay() {
        // Update visual character preview
        binding.characterPreview.updateCharacter(currentCharacter)
    }
    
    
    
    private fun saveCurrentOutfit() {
        gameProgress.savedOutfits.add(currentCharacter.copy())
        gameProgress.addExperience(20)
        gameProgress.earnCoins(10)
        
        saveProgress()
        
        Toast.makeText(this, "Outfit saved! +20 XP, +10 coins", Toast.LENGTH_SHORT).show()
    }
    
    private fun saveProgress() {
        preferencesManager.saveGameProgress(gameProgress)
    }
    
    override fun onPause() {
        super.onPause()
        saveProgress()
    }
}