package com.mywardrobechoices.models

data class WardrobeItem(
    val id: Int,
    val name: String,
    val category: ItemCategory,
    val style: CharacterStyle,
    val imageResId: Int,
    val isUnlocked: Boolean = true,
    val unlockLevel: Int = 1
)

enum class ItemCategory {
    BODY, FACE, HAIR, EYES, TOP, BOTTOM, SHOES, HAT, ACCESSORY, PET, BACKGROUND
}