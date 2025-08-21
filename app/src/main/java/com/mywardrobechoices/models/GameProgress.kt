package com.mywardrobechoices.models

data class GameProgress(
    var level: Int = 1,
    var experience: Int = 0,
    var coins: Int = 100,
    var unlockedItems: MutableSet<Int> = mutableSetOf(),
    var unlockedCharacters: MutableSet<CharacterStyle> = mutableSetOf(CharacterStyle.STYLE_A),
    var savedOutfits: MutableList<Character> = mutableListOf()
) {
    fun addExperience(amount: Int) {
        experience += amount
        checkLevelUp()
    }
    
    private fun checkLevelUp() {
        val requiredExp = level * 100
        if (experience >= requiredExp) {
            level++
            experience -= requiredExp
            // Unlock new items based on level
            unlockItemsForLevel(level)
        }
    }
    
    private fun unlockItemsForLevel(level: Int) {
        when (level) {
            2 -> {
                // Unlock second character style
                unlockedCharacters.add(CharacterStyle.STYLE_B)
            }
            3 -> {
                // Unlock more hair options
                unlockedItems.addAll(listOf(8, 9, 11, 12))
            }
            4 -> {
                // Unlock accessories
                unlockedItems.addAll(listOf(34, 35, 36))
            }
            5 -> {
                // Unlock pets
                unlockedItems.addAll(listOf(37, 38, 39))
            }
        }
    }
    
    fun canAfford(cost: Int): Boolean = coins >= cost
    
    fun spendCoins(amount: Int): Boolean {
        return if (canAfford(amount)) {
            coins -= amount
            true
        } else {
            false
        }
    }
    
    fun earnCoins(amount: Int) {
        coins += amount
    }
}