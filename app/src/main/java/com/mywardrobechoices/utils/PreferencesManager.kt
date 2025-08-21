package com.mywardrobechoices.utils

import android.content.Context
import android.content.SharedPreferences
import com.mywardrobechoices.models.GameProgress
import com.mywardrobechoices.models.CharacterStyle

class PreferencesManager(context: Context) {
    
    private val prefs: SharedPreferences = context.getSharedPreferences(
        "wardrobe_prefs", Context.MODE_PRIVATE
    )
    
    fun saveGameProgress(progress: GameProgress) {
        prefs.edit().apply {
            putInt("level", progress.level)
            putInt("experience", progress.experience)
            putInt("coins", progress.coins)
            putStringSet("unlocked_items", progress.unlockedItems.map { it.toString() }.toSet())
            putStringSet("unlocked_characters", progress.unlockedCharacters.map { it.name }.toSet())
            apply()
        }
    }
    
    fun loadGameProgress(): GameProgress {
        val level = prefs.getInt("level", 1)
        val experience = prefs.getInt("experience", 0)
        val coins = prefs.getInt("coins", 100)
        
        val unlockedItemsStrings = prefs.getStringSet("unlocked_items", emptySet()) ?: emptySet()
        val unlockedItems = unlockedItemsStrings.mapNotNull { it.toIntOrNull() }.toMutableSet()
        
        val unlockedCharacterStrings = prefs.getStringSet("unlocked_characters", setOf("STYLE_A")) ?: setOf("STYLE_A")
        val unlockedCharacters = unlockedCharacterStrings.mapNotNull { 
            try { CharacterStyle.valueOf(it) } catch (e: Exception) { null }
        }.toMutableSet()
        
        return GameProgress(
            level = level,
            experience = experience,
            coins = coins,
            unlockedItems = unlockedItems,
            unlockedCharacters = unlockedCharacters
        )
    }
    
    fun clearProgress() {
        prefs.edit().clear().apply()
    }
}