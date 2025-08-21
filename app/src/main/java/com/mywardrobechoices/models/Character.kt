package com.mywardrobechoices.models

data class Character(
    var style: CharacterStyle = CharacterStyle.STYLE_A,
    var face: Int = 0,
    var hair: Int = 0,
    var eyes: Int = 0,
    var outfit: Outfit = Outfit(),
    var accessories: MutableList<Accessory> = mutableListOf(),
    var pet: Pet? = null,
    var background: Int = 0
)

enum class CharacterStyle {
    STYLE_A, STYLE_B
}

data class Outfit(
    var top: Int = 0,
    var bottom: Int = 0,
    var shoes: Int = 0,
    var hat: Int? = null
)

data class Accessory(
    val id: Int,
    val type: AccessoryType,
    val name: String,
    val isUnlocked: Boolean = true
)

enum class AccessoryType {
    JEWELRY, GLASSES, BAG, WATCH, OTHER
}

data class Pet(
    val id: Int,
    val type: PetType,
    val name: String,
    val isUnlocked: Boolean = true
)

enum class PetType {
    DOG, CAT, BIRD, RABBIT, HAMSTER
}